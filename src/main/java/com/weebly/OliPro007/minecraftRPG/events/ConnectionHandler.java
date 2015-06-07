package com.weebly.OliPro007.minecraftRPG.events;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

import com.weebly.OliPro007.minecraftRPG.network.MessageSkillUpdate;
import com.weebly.OliPro007.minecraftRPG.network.PacketHandler;
import com.weebly.OliPro007.minecraftRPG.skills.Skill;
import com.weebly.OliPro007.minecraftRPG.skills.SkillRegistry;
import com.weebly.OliPro007.minecraftRPG.utilities.LogHandler;

import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

public class ConnectionHandler {

	@SubscribeEvent
	public void onPlayerConnected(PlayerLoggedInEvent event){
		if(!SkillRegistry.getPlayers().isEmpty())
			PacketHandler.instance().sendTo(new MessageSkillUpdate(SkillRegistry.getPlayers()), (EntityPlayerMP) event.player);
		
		String playerName = event.player.getGameProfile().getName();
		SkillRegistry.addPlayer(playerName);
		
		NBTTagCompound compound = event.player.getEntityData();
		for(Skill skill : SkillRegistry.getSkills()){
			SkillRegistry.getSkillsOfPlayer(playerName).get(skill.getType()).setEXP(compound.getInteger(skill.getType()));
		}
		
		PacketHandler.instance().sendTo(new MessageSkillUpdate(playerName, SkillRegistry.getSkillsOfPlayer(playerName)), (EntityPlayerMP) event.player);
		PacketHandler.instance().sendToAll(new MessageSkillUpdate(playerName, SkillRegistry.getSkillsOfPlayer(playerName)));
	}
	
	@SubscribeEvent
	public void onPlayerDisconnnected(PlayerLoggedOutEvent event){
		LogHandler.info("Player " + event.player.getGameProfile().getName() + " logging out");
		NBTTagCompound compound = event.player.getEntityData();
		for(Skill skill : SkillRegistry.getSkillsOfPlayer(event.player.getGameProfile().getName()).values()){
			compound.setInteger(skill.getType(), skill.getExp());
		}
		SkillRegistry.removePlayer(event.player.getGameProfile().getName());
	}
	
}
