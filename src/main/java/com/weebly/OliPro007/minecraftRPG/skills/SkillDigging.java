package com.weebly.OliPro007.minecraftRPG.skills;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class SkillDigging extends Skill {
	
	//Same array as the effective array for the shovels
	private static final Block[] blocksArray = new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, 
		 Blocks.snow, Blocks.snow_layer, Blocks.clay, Blocks.farmland, 
		 Blocks.soul_sand, Blocks.mycelium};
	private static final Set blocks = new HashSet(Arrays.asList(blocksArray));
	
	SkillDigging(){
		super("Digging");
	}

	@Override
	public void levelEffects(int level) {
		
	}
	
	public static Set getBlocks(){
		return blocks;
	}

}
