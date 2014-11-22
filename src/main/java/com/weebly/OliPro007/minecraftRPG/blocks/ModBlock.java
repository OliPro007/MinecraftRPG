package com.weebly.OliPro007.minecraftRPG.blocks;

import com.weebly.OliPro007.minecraftRPG.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class ModBlock extends Block{
	
	public ModBlock(Material material, float hardness, float resist, int opacity, float luminance, 
					Block.SoundType stepSound, CreativeTabs tab, String name) {
		super(material);
		this.setHardness(hardness);
		this.setResistance(resist);
		this.setLightOpacity(opacity);
		this.setLightLevel(luminance);
		this.setStepSound(stepSound);
		this.setCreativeTab(tab);
		this.setBlockName(name);
	}
	
	@Override
	public String getUnlocalizedName(){
		return String.format("tile.%s%s", References.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName){
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

}
