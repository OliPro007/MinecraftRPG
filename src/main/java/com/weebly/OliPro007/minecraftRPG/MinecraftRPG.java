package com.weebly.OliPro007.minecraftRPG;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.weebly.OliPro007.minecraftRPG.blocks.ModBlock;
import com.weebly.OliPro007.minecraftRPG.creativeTabs.CreativeTabMod;
import com.weebly.OliPro007.minecraftRPG.entities.EntityBullet;
import com.weebly.OliPro007.minecraftRPG.items.Bullet;
import com.weebly.OliPro007.minecraftRPG.items.BulletTypes;
import com.weebly.OliPro007.minecraftRPG.items.Gun;
import com.weebly.OliPro007.minecraftRPG.items.Magazine;
import com.weebly.OliPro007.minecraftRPG.items.Steel;
import com.weebly.OliPro007.minecraftRPG.items.SteelAxe;
import com.weebly.OliPro007.minecraftRPG.items.SteelHoe;
import com.weebly.OliPro007.minecraftRPG.items.SteelPickaxe;
import com.weebly.OliPro007.minecraftRPG.items.SteelShovel;
import com.weebly.OliPro007.minecraftRPG.items.SteelSword;
import com.weebly.OliPro007.minecraftRPG.proxy.IProxy;
import com.weebly.OliPro007.minecraftRPG.utilities.ConfigHandler;
import com.weebly.OliPro007.minecraftRPG.utilities.LogHandler;
import com.weebly.OliPro007.minecraftRPG.utilities.References;
import com.weebly.OliPro007.minecraftRPG.utilities.TexturesHandler;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, version = References.VERSION)
public class MinecraftRPG {
    
    @Mod.Instance(References.MODID)
    public static MinecraftRPG instance;
    
    @SidedProxy(clientSide = References.CLIENTPROXY, serverSide = References.SERVERPROXY)
    public static IProxy proxy;
    
    /*==============*\
    |* Declarations *|
    \*==============*/    
    public static Item steelBase;
	public static Item steelIngot;
	public static Item steelAxe;
	public static Item steelPickaxe;
	public static Item steelShovel;
	public static Item steelSword;
	public static Item steelHoe;
	public static Item arMFour;
	public static Item arAmmo;
	public static Item arMag;
	public static Block steelBlock;
	public static CreativeTabs modTab;	
	/*==================*\
	|* End Declarations *|
	\*==================*/
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	LogHandler.info("Starting pre-initialisation, checking for config file and optional mods...");
    	ConfigHandler.init(event.getSuggestedConfigurationFile());
    	if(Loader.isModLoaded("TConstruct")){
    		LogHandler.info("Tinker's construct is loaded, no need to add aluminum.");
    		ConfigHandler.addAluminum = false;
    	}
    	if(Loader.isModLoaded("TSteelworks")){
    		LogHandler.info("Tinker's steelworks is loaded, no need to add steel.");
    		ConfigHandler.addSteel = false;
    	}
    	
    	modTab = new CreativeTabMod(12, References.MODID);
    	
    	if(ConfigHandler.addSteel){
			steelBase = new Steel(64, modTab, TexturesHandler.STEEL_BASE_TEXTURE, "steelBase");
			GameRegistry.registerItem(steelBase, "steelBase");
			OreDictionary.registerOre("steelBase", steelBase);
			steelIngot = new Steel(64, modTab, TexturesHandler.STEEL_INGOT_TEXTURE, "steelIngot");
			GameRegistry.registerItem(steelIngot, "steelIngot");
			OreDictionary.registerOre("steelIngot", steelIngot);
			
			steelAxe = new SteelAxe(3.0F, modTab, TexturesHandler.STEEL_AXE, "steelAxe");
			GameRegistry.registerItem(steelAxe, "steelAxe");
			steelPickaxe = new SteelPickaxe(2.0F, modTab, TexturesHandler.STEEL_PICKAXE, "steelPickaxe");
			GameRegistry.registerItem(steelPickaxe, "steelPickaxe");
			steelShovel = new SteelShovel(1.0F, modTab, TexturesHandler.STEEL_SHOVEL, "steelShovel");
			GameRegistry.registerItem(steelShovel, "steelSpade");
			steelSword = new SteelSword(modTab, TexturesHandler.STEEL_SWORD, "steelSword");
			GameRegistry.registerItem(steelSword, "steelSword");
			steelHoe = new SteelHoe(modTab, TexturesHandler.STEEL_HOE, "steelHoe");
			GameRegistry.registerItem(steelHoe, "steelHoe");
			
			steelBlock = new ModBlock(Material.iron, 5.0F, 10.0F, 100, 0.0F, Block.soundTypeMetal, modTab, TexturesHandler.STEEL_BLOCK, "steelBlock");
			steelBlock.setHarvestLevel("pickaxe", 2);
			GameRegistry.registerBlock(steelBlock, "steelBlock");
			OreDictionary.registerOre("steelBlock", steelBlock);			
    	}
    	
    	EntityRegistry.registerModEntity(EntityBullet.class, "ARBullet", 1, instance, 120, 10, true);
		
		arAmmo = new Bullet(BulletTypes.AR, modTab);
		GameRegistry.registerItem(arAmmo, "arAmmo");
		arMag = new Magazine(30, (Bullet)arAmmo, modTab, TexturesHandler.AR_MAG, "arMag").setContainerItem(arMag);
		GameRegistry.registerItem(arMag, "arMag");
		arMFour = new Gun((Magazine)arMag, modTab, TexturesHandler.AR_M_FOUR, "m4");
		GameRegistry.registerItem(arMFour, "m4");
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
		LogHandler.info("Starting initialisation, initializing recipes");
		
		proxy.registerRenderers();
		
		if(ConfigHandler.addSteel){
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
		
		GameRegistry.addShapelessRecipe(new ItemStack(arMag, 1, arMag.getMaxDamage()), new ItemStack(Items.diamond));
		//GameRegistry.addShapelessRecipe(, new ItemStack(arAmmo), new ItemStack(arMag, 1, OreDictionary.WILDCARD_VALUE));
		//STILL HAVEN'T FOUND OUT HOW TO ADD BULLET TO THE MAG
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    }
}
