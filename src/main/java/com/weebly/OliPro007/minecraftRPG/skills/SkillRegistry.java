package com.weebly.OliPro007.minecraftRPG.skills;

import java.util.Collection;
import java.util.HashMap;

import com.weebly.OliPro007.minecraftRPG.utilities.LogHandler;

public class SkillRegistry {
	
	private static HashMap<String, Skill> skills = new HashMap<String, Skill>();
	private static HashMap<String, HashMap<String, Skill>> players = new HashMap<String, HashMap<String,Skill>>();
	
	public static void init(){
		Skill.calculateEXP();
		SkillRegistry.registerSkill(new SkillMining());
		SkillRegistry.registerSkill(new SkillDigging());
	}
	
	public static void registerSkill(Skill skill){
		if(skills.containsKey(skill.getType())){
			LogHandler.info("Overriding skill: " + skill.getType());
		}
		skills.put(skill.getType(), skill);
	}
	
	public static void unregisterSkill(Skill skill){
		if(skills.containsKey(skill.getType())){
			skills.remove(skill.getType());
		}
	}
	
	public static Skill getSkill(String type){
		if(skills.containsKey(type.toUpperCase())){
			return skills.get(type.toUpperCase());
		}
		return null;
	}
	
	public static Collection<Skill> getSkills(){
		return skills.values();
	}
	
	public static boolean hasSkill(String type){
		return skills.containsKey(type);
	}
	
	public static void addPlayer(String player){
		players.put(player, new HashMap<String, Skill>(skills));
	}
	
	public static void removePlayer(String player){
		players.remove(player);
	}
	
	public static HashMap<String, HashMap<String, Skill>> getPlayers(){
		return players;
	}
	
	public static HashMap<String, Skill> getSkillsOfPlayer(String player){
		if(players.containsKey(player))
			return players.get(player);
		else
			return null;
	}
	
}
