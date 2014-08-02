package com.weebly.OliPro007.minecraftRPG.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.weebly.OliPro007.minecraftRPG.MinecraftRPG;
import com.weebly.OliPro007.minecraftRPG.utilities.LogHandler;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void initCommonRecipes(){
		LogHandler.info("Initializing gun recipes");
		GameRegistry.addShapelessRecipe(new ItemStack(MinecraftRPG.arMag, 1, MinecraftRPG.arMag.getMaxDamage()), 
										new ItemStack(Items.diamond));
		GameRegistry.addRecipe(new RepairRecipe(MinecraftRPG.arMag, new ItemStack(MinecraftRPG.arAmmo), 1));
	}
	
	public static void initSteelRecipes(){
		LogHandler.info("Initializing basic steel recipes");
		
		ItemStack steelBaseStack = new ItemStack(MinecraftRPG.steelBase);
		ItemStack steelIngotStack = new ItemStack(MinecraftRPG.steelIngot);
		ItemStack coalStack = new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE);
		ItemStack oreIronStack = new ItemStack(Blocks.iron_ore);
		GameRegistry.addShapelessRecipe(steelBaseStack, oreIronStack, new ItemStack(Blocks.coal_ore));
		GameRegistry.addShapelessRecipe(steelBaseStack, oreIronStack, coalStack, coalStack, coalStack);
		GameRegistry.addSmelting(MinecraftRPG.steelBase, new ItemStack(MinecraftRPG.steelIngot), 0.7F);
		GameRegistry.addShapelessRecipe(new ItemStack(MinecraftRPG.steelBlock), steelIngotStack, steelIngotStack, steelIngotStack, 
																   				steelIngotStack, steelIngotStack, steelIngotStack, 
																   				steelIngotStack, steelIngotStack, steelIngotStack);
	}
	
	public static void initAluminumRecipes(){
		LogHandler.info("Initializing basic aluminum recipes");
	}
	
}
