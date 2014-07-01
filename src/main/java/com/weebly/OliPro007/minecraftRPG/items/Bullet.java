package com.weebly.OliPro007.minecraftRPG.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Bullet extends Item{

	private static BulletTypes type;
	
	public Bullet(BulletTypes type, CreativeTabs tab) {
		this.type = type;
		this.setCreativeTab(tab);
		this.setTextureName(type.getTexture());
		this.setUnlocalizedName(type.getName());
	}
	
	public BulletTypes getBulletType(){
		return type;
	}
	
}
