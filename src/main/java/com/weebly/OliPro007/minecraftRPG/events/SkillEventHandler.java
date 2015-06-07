package com.weebly.OliPro007.minecraftRPG.events;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

import com.weebly.OliPro007.minecraftRPG.network.MessageSkillUpdate;
import com.weebly.OliPro007.minecraftRPG.network.PacketHandler;
import com.weebly.OliPro007.minecraftRPG.skills.SkillDigging;
import com.weebly.OliPro007.minecraftRPG.skills.SkillMining;
import com.weebly.OliPro007.minecraftRPG.skills.SkillRegistry;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SkillEventHandler {
	
	@SubscribeEvent
	public void onBlockBroken(BreakEvent event){
		if(!event.isCanceled()){
			String playerName = event.getPlayer().getGameProfile().getName();		
			
			if(SkillMining.getBlocks().contains(event.block)){
				SkillRegistry.getSkillsOfPlayer(playerName).get("MINING").addEXP(10);
				System.out.println("Mining: " + SkillRegistry.getSkillsOfPlayer(playerName).get("MINING").getExp());
			}
			if(SkillDigging.getBlocks().contains(event.block)){
				SkillRegistry.getSkillsOfPlayer(playerName).get("DIGGING").addEXP(10);
				System.out.println("Digging " + SkillRegistry.getSkillsOfPlayer(playerName).get("DIGGING").getExp());
			}
			
			PacketHandler.instance().sendToAll(new MessageSkillUpdate(playerName, SkillRegistry.getSkillsOfPlayer(playerName)));
		}
	}

}
