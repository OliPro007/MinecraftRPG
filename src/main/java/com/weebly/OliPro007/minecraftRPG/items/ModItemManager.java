package com.weebly.OliPro007.minecraftRPG.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

import com.weebly.OliPro007.minecraftRPG.MinecraftRPG;
import com.weebly.OliPro007.minecraftRPG.blocks.ModBlock;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItemManager {

	public static void initSteelItems(){
		MinecraftRPG.steelBase = new Steel(64, MinecraftRPG.modTab, "steelBase");
		GameRegistry.registerItem(MinecraftRPG.steelBase, "steelBase");
		OreDictionary.registerOre("steelBase", MinecraftRPG.steelBase);
		MinecraftRPG.steelIngot = new Steel(64, MinecraftRPG.modTab, "steelIngot");
		GameRegistry.registerItem(MinecraftRPG.steelIngot, "steelIngot");
		OreDictionary.registerOre("steelIngot", MinecraftRPG.steelIngot);
		
		MinecraftRPG.steelAxe = new SteelAxe(3.0F, MinecraftRPG.modTab, "steelAxe");
		GameRegistry.registerItem(MinecraftRPG.steelAxe, "steelAxe");
		MinecraftRPG.steelPickaxe = new SteelPickaxe(2.0F, MinecraftRPG.modTab, "steelPickaxe");
		GameRegistry.registerItem(MinecraftRPG.steelPickaxe, "steelPickaxe");
		MinecraftRPG.steelShovel = new SteelShovel(1.0F, MinecraftRPG.modTab, "steelShovel");
		GameRegistry.registerItem(MinecraftRPG.steelShovel, "steelSpade");
		MinecraftRPG.steelSword = new SteelSword(MinecraftRPG.modTab, "steelSword");
		GameRegistry.registerItem(MinecraftRPG.steelSword, "steelSword");
		MinecraftRPG.steelHoe = new SteelHoe(MinecraftRPG.modTab, "steelHoe");
		GameRegistry.registerItem(MinecraftRPG.steelHoe, "steelHoe");
		
		MinecraftRPG.steelBlock = new ModBlock(Material.iron, 5.0F, 10.0F, 100, 0.0F, Block.soundTypeMetal, MinecraftRPG.modTab, "steelBlock");
		MinecraftRPG.steelBlock.setHarvestLevel("pickaxe", 2);
		GameRegistry.registerBlock(MinecraftRPG.steelBlock, "steelBlock");
		OreDictionary.registerOre("steelBlock", MinecraftRPG.steelBlock);
	}
	
	public static void initAluminumItems(){
		
	}
	
}
