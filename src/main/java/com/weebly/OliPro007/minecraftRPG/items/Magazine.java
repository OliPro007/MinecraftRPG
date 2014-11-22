package com.weebly.OliPro007.minecraftRPG.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Magazine extends ModItem{
	
	private static Bullet bulletType;
	private ItemStack emptyItem = null;

	public Magazine(int maxAmmo, Bullet bulletType, CreativeTabs tab, String name) {
		this.setMaxDamage(maxAmmo + 1);
		this.bulletType = bulletType;
		this.setCreativeTab(tab);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
	public Bullet getBullet(){
		return bulletType;
	}

}
