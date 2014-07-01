package com.weebly.OliPro007.minecraftRPG.items;

import java.util.Set;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemTool;

public class SteelTool extends ItemTool{
	
	public SteelTool(float damage, Set effectiveBlocks, CreativeTabs tab, String texture, String name) {
		super(damage, Steel.STEEL, effectiveBlocks);
		this.setTextureName(texture);
		this.setCreativeTab(tab);
		this.setUnlocalizedName(name);
	}

}
