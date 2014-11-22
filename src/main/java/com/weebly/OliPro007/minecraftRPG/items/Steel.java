package com.weebly.OliPro007.minecraftRPG.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.weebly.OliPro007.minecraftRPG.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Steel extends ModItem{
	
	public static ToolMaterial STEEL = new EnumHelper().addToolMaterial("STEEL", 2, 500, 7.0F, 2.5F, 14);

	public Steel(int maxStackSize, CreativeTabs tab, String name){
		this.setMaxStackSize(maxStackSize);
		this.setCreativeTab(tab);
		this.setUnlocalizedName(name);
	}

}
