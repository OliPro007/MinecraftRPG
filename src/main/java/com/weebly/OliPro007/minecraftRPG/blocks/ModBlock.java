package com.weebly.OliPro007.minecraftRPG.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlock extends Block{
	
	public ModBlock(Material material, float hardness, float resist, int opacity, float luminance, 
					Block.SoundType stepSound, CreativeTabs tab, String texture, String name) {
		super(material);
		this.setHardness(hardness);
		this.setResistance(resist);
		this.setLightOpacity(opacity);
		this.setLightLevel(luminance);
		this.setStepSound(stepSound);
		this.setCreativeTab(tab);
		this.setBlockTextureName(texture);
		this.setBlockName(name);
	}

}
