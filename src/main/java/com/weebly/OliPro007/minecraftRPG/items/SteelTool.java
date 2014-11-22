package com.weebly.OliPro007.minecraftRPG.items;

import java.util.Set;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemTool;

public class SteelTool extends ModTool{
	
	public SteelTool(float damage, Set effectiveBlocks, CreativeTabs tab, String name) {
		super(damage, Steel.STEEL, effectiveBlocks, tab, name);
	}

}
