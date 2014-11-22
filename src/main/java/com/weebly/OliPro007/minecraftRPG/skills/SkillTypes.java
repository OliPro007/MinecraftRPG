package com.weebly.OliPro007.minecraftRPG.skills;

import java.util.ArrayList;

public enum SkillTypes{
	MINING("Mining"),
	DIGGING("Digging"),
	WOODCUTTING("Woodcutting"),
	RUNNING("Running"),
	PUNCHING("Punching"),
	MARKSMANSHIP("Marksmanship"),
	SWORDMANSHIP("Swordmanship");
	
	public ArrayList<SkillTypes> skills = new ArrayList<SkillTypes>();
	
	private String name;
	
	private SkillTypes(String name){
		this.name = name;
		skills.add(this);
	}
	
	/**
	 * @return The name of the skill type
	 */
	public String getName(){
		return this.name;
	}
}
