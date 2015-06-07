package com.weebly.OliPro007.minecraftRPG.skills;

import java.io.Serializable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

import com.weebly.OliPro007.minecraftRPG.utilities.LogHandler;

public abstract class Skill implements Serializable {
		
	private static int[] expNeeded = new int[100];
	
	private String type;
	private int level;
	private int exp;
	private int totalEXP;
	
	public Skill(String type){
		this.type = type.toUpperCase();
		this.level = 1;
		this.exp = 0;
		this.totalEXP = 0;
	}
	
	public Skill(String type, int level, int exp){
		this.type = type.toUpperCase();
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
			this.totalEXP += amount;
			while(this.exp >= getNeededEXP(this.level)){
				this.levelUp();
			}
		}
	}
	
	public void levelUp(){
		this.exp -= getNeededEXP(this.level);
		this.level++;
		
		LogHandler.debug("Level up " + this.type + " to level " + this.level + "!");
		ChatComponentStyle text = new ChatComponentText("Level up " + this.type + " to level " + this.level + "!");
		ChatStyle style = new ChatStyle();
		style.setItalic(true);
		style.setColor(EnumChatFormatting.GOLD);
		text.setChatStyle(style);
		Minecraft.getMinecraft().thePlayer.addChatMessage(text);
	}
	
	public static void calculateEXP(){
		for(int level = 1; level <= 100; level++){
			expNeeded[level - 1] = level * level * 50;
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
	
	public String getType(){
		return this.type;
	}
	
	public int getExp(){
		return this.totalEXP;
	}
	
	public abstract void levelEffects(int level);
	
}
