package com.weebly.OliPro007.minecraftRPG.utilities;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler {
	
	public static boolean addAluminum = true;
	public static boolean addSteel = true;
	
	private static Configuration config;
	
	public enum ConfigCategories{
		DEPENDANCIES("Dependancies", "Detected automatically, can't be modified");
		
		private String name;
		
		ConfigCategories(String name, String comment){
			this.name = name;
			config.addCustomCategoryComment(name, comment);
		}
		
		public String getName(){
			return this.name;
		}
	}

	public static void init(File configFile){
		config = new Configuration(configFile);
		
		try{
			config.load();
			
			addAluminum = config.get(ConfigCategories.DEPENDANCIES.getName(), "AddAluminum", true, "Is false if tinker's construct is installed.").getBoolean(true);
			addSteel = config.get(ConfigCategories.DEPENDANCIES.getName(), "AddSteel", true, "Is false if tinker's steelwork is installed.").getBoolean(true);
		}catch(Exception e){
			LogHandler.error(e);
		}finally{
			config.save();
		}
	}
	
	public static void modify(ConfigCategories category, String key, boolean value){
		try{
			config.get(category.getName(), key, true).set(value);
		}catch(Exception e){
			LogHandler.error(e);
		}finally{
			config.save();
		}
	}
	
	public static void modify(ConfigCategories category, String key, String value){
		try{
			config.get(category.getName(), key, true).set(value);
		}catch(Exception e){
			LogHandler.error(e);
		}finally{
			config.save();
		}
	}
	
	public static void modify(ConfigCategories category, String key, int value){
		try{
			config.get(category.getName(), key, true).set(value);
		}catch(Exception e){
			LogHandler.error(e);
		}finally{
			config.save();
		}
	}
	
	public static void modify(ConfigCategories category, String key, double value){
		try{
			config.get(category.getName(), key, true).set(value);
		}catch(Exception e){
			LogHandler.error(e);
		}finally{
			config.save();
		}
	}

}
