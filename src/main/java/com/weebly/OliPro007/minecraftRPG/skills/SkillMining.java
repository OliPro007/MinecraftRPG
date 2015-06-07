package com.weebly.OliPro007.minecraftRPG.skills;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class SkillMining extends Skill{
	
	//Same array as the effective array for the pickaxes
	private static final Block[] blocksArray = new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, 
		Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, 
		Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, 
		Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.redstone_block, Blocks.rail, Blocks.activator_rail, 
		Blocks.golden_rail, Blocks.detector_rail};
	private static final Set blocks = new HashSet(Arrays.asList(blocksArray));

	public SkillMining() {
		super("Mining");
	}
	
	@Override
	public void levelEffects(int level){
		
	}
	
	public static Set getBlocks(){
		return blocks;
	}

}
