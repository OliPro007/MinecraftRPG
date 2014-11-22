package com.weebly.OliPro007.minecraftRPG.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GunBench extends ModBlock{

	public GunBench(CreativeTabs tab, String name) {
		super(Material.iron, 5.0F, 10.0F, 100, 0.0F, Block.soundTypeMetal, tab, name);		
	}

}
