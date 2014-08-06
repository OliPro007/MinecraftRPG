package com.weebly.OliPro007.minecraftRPG.utilities;

import java.io.File;

import com.weebly.OliPro007.minecraftRPG.MinecraftRPG;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {
	
	public static ConfigCategory CATEGORY_OPTIONAL_RESOURCES;
	public static ConfigCategory CATEGORY_DEPANDANCIES;
	
	public static Property autoDetectMods;
	public static Property addAluminum;
	public static Property addSteel;	
	
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
		CATEGORY_DEPANDANCIES = config.getCategory("general.depandancies");
		CATEGORY_OPTIONAL_RESOURCES = config.getCategory("general.depandancies.optional_resources");
		CATEGORY_OPTIONAL_RESOURCES.setComment("WARNING: These resources are used in some recipes.\n" +
											   			"Disable only if other mods add these resources.\n" +
											   "NOTE: If autoDetectMods is true, these value are detected automatically.");
		if(!MinecraftRPG.isInPreInit)
			CATEGORY_OPTIONAL_RESOURCES.setRequiresMcRestart(true);
		
		autoDetectMods = config.get(CATEGORY_DEPANDANCIES.getQualifiedName(), "autoDetectMods", true,
									"Should the mod automatically check for other mods to prevent item dupes?");
		addAluminum = config.get(CATEGORY_OPTIONAL_RESOURCES.getQualifiedName(), "addAluminum", true,
								 "Should the mod add aluminum? Will change automatically at startup if autoDetectMods is true.");
		addSteel = config.get(CATEGORY_OPTIONAL_RESOURCES.getQualifiedName(), "addSteel", true,
							  "Should the mod add steel? Will change automatically at startup if autoDetectMods is true.");
		
		if(autoDetectMods.getBoolean() == true){
			CATEGORY_OPTIONAL_RESOURCES.setShowInGui(false);
		}else{
			CATEGORY_OPTIONAL_RESOURCES.setShowInGui(true);
		}
		
		if(config.hasChanged())
			config.save();
	}
	
}
