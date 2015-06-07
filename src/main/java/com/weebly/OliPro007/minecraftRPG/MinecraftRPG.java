package com.weebly.OliPro007.minecraftRPG;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import com.weebly.OliPro007.minecraftRPG.creativeTabs.CreativeTabMod;
import com.weebly.OliPro007.minecraftRPG.entities.EntityBullet;
import com.weebly.OliPro007.minecraftRPG.events.ConnectionHandler;
import com.weebly.OliPro007.minecraftRPG.events.SkillEventHandler;
import com.weebly.OliPro007.minecraftRPG.items.Bullet;
import com.weebly.OliPro007.minecraftRPG.items.BulletTypes;
import com.weebly.OliPro007.minecraftRPG.items.Gun;
import com.weebly.OliPro007.minecraftRPG.items.Magazine;
import com.weebly.OliPro007.minecraftRPG.items.ModItemManager;
import com.weebly.OliPro007.minecraftRPG.network.PacketHandler;
import com.weebly.OliPro007.minecraftRPG.proxy.IProxy;
import com.weebly.OliPro007.minecraftRPG.recipes.ModRecipeManager;
import com.weebly.OliPro007.minecraftRPG.skills.SkillRegistry;
import com.weebly.OliPro007.minecraftRPG.utilities.ConfigHandler;
import com.weebly.OliPro007.minecraftRPG.utilities.LogHandler;
import com.weebly.OliPro007.minecraftRPG.utilities.References;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, name = References.MODID, version = References.VERSION, guiFactory = References.GUIFACTORY)
public class MinecraftRPG {
    
    @Mod.Instance(References.MODID)
    public static MinecraftRPG instance;
    
    @SidedProxy(clientSide = References.CLIENTPROXY, serverSide = References.SERVERPROXY)
    public static IProxy proxy;
    
    public static boolean isInPreInit;
    
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
    	isInPreInit = true;
    	ConfigHandler.init(event.getSuggestedConfigurationFile());
    	FMLCommonHandler.instance().bus().register(new ConfigHandler());
    	if(ConfigHandler.autoDetectMods.getBoolean() == true){
	    	if(Loader.isModLoaded("TConstruct")){
	    		LogHandler.info("Tinker's construct is loaded, no need to add aluminum.");
	    		ConfigHandler.addAluminum.set(false);
	    	}else{
	    		LogHandler.info("Tinker's construct is NOT loaded, adding aluminum.");
	    		ConfigHandler.addAluminum.set(true);
	    	}
	    	if(Loader.isModLoaded("TSteelworks")){
	    		LogHandler.info("Tinker's steelworks is loaded, no need to add steel.");
	    		ConfigHandler.addSteel.set(false);
	    	}else{
	    		LogHandler.info("Tinker's steelworks is NOT loaded, adding steel.");
	    		ConfigHandler.addSteel.set(true);
	    	}
	    	ConfigChangedEvent changed = new ConfigChangedEvent(References.MODID, null, false, false);
	    	FMLCommonHandler.instance().bus().post(changed);
    	}
    	
    	modTab = new CreativeTabMod(12, References.MODID);
    	
    	if(ConfigHandler.addSteel.getBoolean()){
			ModItemManager.initSteelItems();			
    	}
    	if(ConfigHandler.addAluminum.getBoolean()){
			ModItemManager.initAluminumItems();
		}
    	
    	EntityRegistry.registerModEntity(EntityBullet.class, "ARBullet", 1, instance, 120, 10, true);
		
		arAmmo = new Bullet(BulletTypes.AR, modTab);
		GameRegistry.registerItem(arAmmo, "arAmmo");
		arMag = new Magazine(30, (Bullet)arAmmo, modTab, "arMag");
		GameRegistry.registerItem(arMag, "arMag");
		arMFour = new Gun((Magazine)arMag, modTab, "arM4");
		GameRegistry.registerItem(arMFour, "arM4");
    	
		isInPreInit = false;
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
		LogHandler.info("Starting initialisation, initializing recipes");
		
		proxy.registerRenderers();
		
		if(ConfigHandler.addSteel.getBoolean()){
			ModRecipeManager.initSteelRecipes();
		}
		if(ConfigHandler.addAluminum.getBoolean()){
			ModRecipeManager.initAluminumRecipes();
		}
		
		ModRecipeManager.initCommonRecipes();
		
		PacketHandler.init();
    	FMLCommonHandler.instance().bus().register(new ConnectionHandler());
    	MinecraftForge.EVENT_BUS.register(new SkillEventHandler());
		SkillRegistry.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    }
}
