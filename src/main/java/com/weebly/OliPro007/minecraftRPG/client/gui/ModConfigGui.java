package com.weebly.OliPro007.minecraftRPG.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import com.weebly.OliPro007.minecraftRPG.utilities.ConfigHandler;
import com.weebly.OliPro007.minecraftRPG.utilities.References;

import cpw.mods.fml.client.config.GuiConfig;

public class ModConfigGui extends GuiConfig{

	public ModConfigGui(GuiScreen guiScreen){
		super(guiScreen, new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				References.MODID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
	}
	
}
