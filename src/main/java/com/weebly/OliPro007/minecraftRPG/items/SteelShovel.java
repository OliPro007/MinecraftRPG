package com.weebly.OliPro007.minecraftRPG.items;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class SteelShovel extends SteelTool{

	public static final Block[] effectiveArray = new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, 
														 Blocks.snow, Blocks.snow_layer, Blocks.clay, Blocks.farmland, 
														 Blocks.soul_sand, Blocks.mycelium};
	public static final Set effective = new HashSet(Arrays.asList(effectiveArray));
	
	public SteelShovel(float damage, CreativeTabs tab, String texture, String name) {
		super(damage, effective, tab, texture, name);
	}

    /**
     * Formerly called canHarvestBlock
     * Returns if the item (tool) can harvest results from the block type.
     */
	public boolean func_150897_b(Block p_150897_1_)
    {
        return p_150897_1_ == Blocks.snow_layer ? true : p_150897_1_ == Blocks.snow;
    }
	
}
