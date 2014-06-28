package com.weebly.OliPro007.minecraftRPG;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.weebly.OliPro007.minecraftRPG.proxy.IProxy;
import com.weebly.OliPro007.minecraftRPG.utilities.LogHelper;
import com.weebly.OliPro007.minecraftRPG.utilities.References;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, version = References.VERSION)
public class MinecraftRPG {
    
    @Mod.Instance(References.MODID)
    public static MinecraftRPG instance;
    
    @SidedProxy(clientSide = References.CLIENTPROXY, serverSide = References.SERVERPROXY)
    public static IProxy proxy;
    
    /****************
     * Declarations *
     ****************/
    private static boolean addAluminum = true;
    private static boolean addSteel = true;
    
    public static Item steelBase;
	public static Item steelIngot;
	public static Item steelAxe;
	public static Item steelPickaxe;
	public static Item steelSpade;
	public static Item steelSword;
	public static Item steelHoe;
	public static Item arMFour;
	public static Item arAmmo;
	public static Item arMag;
	public static Block steelBlock;
	public static CreativeTabs modTab;	
	/********************
	 * End Declarations *
	 ********************/
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	LogHelper.info("Starting pre-initialisation, checking for optional mods...");
    	if(Loader.isModLoaded("TConstruct")){
    		LogHelper.info("Tinker's construct is loaded, no need to add aluminum.");
    		addAluminum = false;
    	}
    	if(Loader.isModLoaded("TSteelworks")){
    		LogHelper.info("Tinker's steelworks is loaded, no need to add steel.");
    		addSteel = false;
    	}
    	
    	if(addSteel){
			/*steelBase = new Steel(22000, 64, modTab, "minecraftmmorpg:steel_base", "steelBase");
			GameRegistry.registerItem(steelBase, "steelBase");
			OreDictionary.registerOre("steelBase", steelBase);
			steelIngot = new Steel(22001, 64, modTab, "minecraftmmorpg:steel_ingot", "steelIngot");
			GameRegistry.registerItem(steelIngot, "steelIngot");
			OreDictionary.registerOre("steelIngot", steelIngot);
			
			steelAxe = new SteelAxe(22002, 3.0F, modTab, "minecraftmmorpg:steel_axe", "steelAxe");
			GameRegistry.registerItem(steelAxe, "steelAxe");
			steelPickaxe = new SteelPickaxe(22003, 2.0F, modTab, "minecraftmmorpg:steel_pickaxe", "steelPickaxe");
			GameRegistry.registerItem(steelPickaxe, "steelPickaxe");
			steelSpade = new SteelSpade(22004, 1.0F, modTab, "minecraftmmorpg:steel_shovel", "steelSpade");
			GameRegistry.registerItem(steelSpade, "steelSpade");
			steelSword = new SteelSword(22005, modTab, "minecraftmmorpg:steel_sword", "steelSword");
			GameRegistry.registerItem(steelSword, "steelSword");
			steelHoe = new SteelHoe(22006, modTab, "minecraftmmorpg:steel_hoe", "steelHoe");
			GameRegistry.registerItem(steelHoe, "steelHoe");
			
			steelBlock = new ModBlock(1000, Material.iron, 5.0F, 10.0F, 100, 0.0F, Block.soundMetalFootstep, modTab, "minecraftmmorpg:steel_block", "steelBlock");
			GameRegistry.registerBlock(steelBlock, "steelBlock");
			OreDictionary.registerOre("steelBlock", steelBlock);
			MinecraftForge.setBlockHarvestLevel(steelBlock, "pickaxe", 2);*/
    	}
    	
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
		LogHelper.info("Starting initialisation, initializing recipes");
		
		if(addSteel){
			ItemStack steelBaseStack = new ItemStack(steelBase);
			ItemStack steelIngotStack = new ItemStack(steelIngot);
			ItemStack coalStack = new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE);
			ItemStack oreIronStack = new ItemStack(Blocks.iron_ore);
			GameRegistry.addShapelessRecipe(steelBaseStack, oreIronStack, new ItemStack(Blocks.coal_ore));
			GameRegistry.addShapelessRecipe(steelBaseStack, oreIronStack, coalStack, coalStack, coalStack);
			GameRegistry.addSmelting(steelBase, new ItemStack(steelIngot), 0.7F);
			GameRegistry.addShapelessRecipe(new ItemStack(steelBlock), steelIngotStack, steelIngotStack, steelIngotStack, 
																	   steelIngotStack, steelIngotStack, steelIngotStack, 
																	   steelIngotStack, steelIngotStack, steelIngotStack);
		} //End Steel Recipes
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    }
}
