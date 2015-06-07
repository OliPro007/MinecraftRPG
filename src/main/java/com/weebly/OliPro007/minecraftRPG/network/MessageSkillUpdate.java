package com.weebly.OliPro007.minecraftRPG.network;

import io.netty.buffer.ByteBuf;

import java.util.HashMap;

import com.weebly.OliPro007.minecraftRPG.skills.Skill;
import com.weebly.OliPro007.minecraftRPG.skills.SkillRegistry;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSkillUpdate implements IMessage, IMessageHandler<MessageSkillUpdate, IMessage> {
	
	private String player;
	private HashMap<String, Skill> skills;
	private HashMap<String, HashMap<String, Skill>> players;
	
	public MessageSkillUpdate(){}
	
	public MessageSkillUpdate(String player, Skill skill){
		this.player = player;
		this.skills = new HashMap<String, Skill>();
		this.skills.put(skill.getType(), skill);
	}
	
	public MessageSkillUpdate(String player, HashMap<String, Skill> skills){
		this.player = player;
		this.skills = new HashMap<String, Skill>(skills);
	}
	
	public MessageSkillUpdate(HashMap<String, HashMap<String, Skill>> players){
		this.players = new HashMap<String, HashMap<String, Skill>>(players);
	}

	@Override
	public IMessage onMessage(MessageSkillUpdate message, MessageContext ctx) {
		if(message.players != null && !message.players.isEmpty()){ //Handle all players
			for(String p : message.players.keySet()){
				if(!SkillRegistry.getPlayers().containsKey(p))
					SkillRegistry.addPlayer(p);
				for(Skill skill : SkillRegistry.getSkillsOfPlayer(p).values()){
					skill.setEXP(message.skills.get(skill.getType()).getExp());
				}
			}
		}else if(message.skills.size() > 1){ //Handle all skills
			if(!SkillRegistry.getPlayers().containsKey(message.player))
				SkillRegistry.addPlayer(message.player);
			for(Skill skill : SkillRegistry.getSkillsOfPlayer(message.player).values()){
				skill.setEXP(message.skills.get(skill.getType()).getExp());
			}
		}else{ //Handle only one skill
			if(!SkillRegistry.getPlayers().containsKey(message.player))
				SkillRegistry.addPlayer(message.player);
			Skill skill = message.skills.values().iterator().next();
			SkillRegistry.getSkillsOfPlayer(message.player).get(skill.getType()).setEXP(skill.getExp());
		}
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		if(!buf.readBoolean()){ //For one player
			int playerLenght = buf.readInt();
			byte[] playerBytes = buf.readBytes(playerLenght).array();
			player = new String(playerBytes);
			skills = new HashMap<String, Skill>();
			while(buf.isReadable()){
				int skillLenght = buf.readInt();
				byte[] skillNameBytes = buf.readBytes(skillLenght).array();
				String skillName = new String(skillNameBytes);
				int skillExp = buf.readInt();
				Skill skill = SkillRegistry.getSkill(skillName);
				skill.setEXP(skillExp);
				skills.put(skillName, skill);
			}
		}else{ //For all players
			players = new HashMap<String, HashMap<String,Skill>>();
			while(buf.isReadable()){
				int playerLenght = buf.readInt();
				byte[] playerBytes = buf.readBytes(playerLenght).array();
				player = new String(playerBytes);
				skills = new HashMap<String, Skill>();
				while(buf.readBoolean()){
					int skillLenght = buf.readInt();
					byte[] skillNameBytes = buf.readBytes(skillLenght).array();
					String skillName = new String(skillNameBytes);
					int skillExp = buf.readInt();
					Skill skill = SkillRegistry.getSkill(skillName);
					skill.setEXP(skillExp);
					skills.put(skillName, skill);
				}
				players.put(player, skills);
			}
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		if(players == null){ //For one player
			buf.writeBoolean(false);
			buf.writeInt(player.getBytes().length); //Size of player name
			buf.writeBytes(player.getBytes()); //Player name
			for(Skill skill : skills.values()){ //Do all skills, even if there is just one in it.
				buf.writeInt(skill.getType().getBytes().length); //Size of skill name
				buf.writeBytes(skill.getType().getBytes()); //Skill name
				buf.writeInt(skill.getExp()); //Total exp
			}
		}else{ //For all players
			buf.writeBoolean(true);
			for(String name : players.keySet()){
				buf.writeInt(player.getBytes().length); //Size of player name
				buf.writeBytes(player.getBytes()); //Player name
				for(Skill skill : ((HashMap<String, Skill>) players.values()).values()){ //Do all skills, even if there is just one in it.
					buf.writeBoolean(true);
					buf.writeInt(skill.getType().getBytes().length); //Size of skill name
					buf.writeBytes(skill.getType().getBytes()); //Skill name
					buf.writeInt(skill.getExp()); //Total exp
				}
				buf.writeBoolean(false);
			}
		}
	}

}
