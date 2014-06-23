package com.weebly.OliPro007.minecraftRPG;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = MinecraftRPG.MODID, version = MinecraftRPG.VERSION)
public class MinecraftRPG
{
    public static final String MODID = "MinecraftRPG";
    public static final String VERSION = "1.7.2-0.0.2";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
