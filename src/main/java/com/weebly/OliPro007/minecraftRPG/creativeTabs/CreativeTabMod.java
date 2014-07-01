package com.weebly.OliPro007.minecraftRPG.creativeTabs;

import com.weebly.OliPro007.minecraftRPG.MinecraftRPG;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabMod extends CreativeTabs{
	
    public CreativeTabMod(int pos, String name){
        super(pos, name);
    }
    
    /**
     * the itemID for the item to be displayed on the tab
     */
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		 return MinecraftRPG.arMFour;
	}
}
