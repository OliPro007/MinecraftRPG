package com.weebly.OliPro007.minecraftRPG.skills;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.nbt.NBTTagCompound;


public class Skill {
	
	private static int[] expNeeded = new int[100];
	
	private SkillTypes skill;
	private int level;
	private int exp;
	private int totalEXP;
	
	public Skill(SkillTypes skill){
		this.skill = skill;
		this.level = 0;
		this.exp = 0;
		this.totalEXP = 0;
	}
	
	public Skill(SkillTypes skill, int level, int exp){
		this.skill = skill;
		this.level = level;
		this.exp = exp;
		this.totalEXP = exp;
		for(int i=1; i<=level; i++){
			this.totalEXP += getNeededEXP(i);
		}
	}
	
	public void addEXP(int amount){
		if(this.level < 100){
			this.exp += amount;
			this.totalEXP = this.exp;
			while(this.exp >= getNeededEXP(this.level)){
				this.levelUp();
			}
		}
	}
	
	public void levelUp(){
		this.exp = this.exp - getNeededEXP(this.level);
		this.level++;
	}
	
	public static void calculateEXP(){
		for(int i = 0; i < 100; i++){
			expNeeded[i] = i * i * 50;
		}
	}
	
	public static int getNeededEXP(int level){
		return expNeeded[level - 1];
	}
		
	public void setEXP(int exp){
		this.totalEXP = exp;
		this.exp = exp;
		while(this.exp >= getNeededEXP(this.level)){
			this.levelUp();
		}
	}
	
	public void setLevel(int level){
		this.level = level;
		this.totalEXP = 0;
		for(int i=1; i<=level; i++){
			this.totalEXP += getNeededEXP(i);
		}
	}
	
	public void levelEffects(int level){}
	
}
