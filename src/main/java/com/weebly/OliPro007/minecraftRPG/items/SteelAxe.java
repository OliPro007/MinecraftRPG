package com.weebly.OliPro007.minecraftRPG.items;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class SteelAxe extends SteelTool{
	
	private static final Block[] effectiveArray = new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.double_wooden_slab, Blocks.wooden_slab, Blocks.pumpkin, Blocks.lit_pumpkin};
	private static final Set effective = new HashSet(Arrays.asList(effectiveArray));
	
	public SteelAxe(float damage, CreativeTabs tab, String name) {
		super(damage, effective, tab, name);
	}
	
    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
    	return p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    }

}
