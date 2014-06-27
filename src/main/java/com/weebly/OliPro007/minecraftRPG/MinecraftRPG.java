package com.weebly.OliPro007.minecraftRPG;

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
    	
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
		
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    }
}
