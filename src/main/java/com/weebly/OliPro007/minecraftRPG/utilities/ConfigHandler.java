package com.weebly.OliPro007.minecraftRPG.utilities;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {
	
	public static boolean addAluminum = true;
	public static boolean addSteel = true;
	
	public static boolean testValue;
	
	public static Configuration config;

	public static void init(File configFile){
		if(config == null){
			config = new Configuration(configFile);
			loadConfig();
		}
	}
	
	@SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent event){
		if(event.modID.equalsIgnoreCase(References.MODID)){
			loadConfig();
		}
	}
	
	private static void loadConfig(){
		testValue = config.getBoolean("configValue", Configuration.CATEGORY_GENERAL, true, "A test value");
		
		if(config.hasChanged())
			config.save();
	}
	
}
