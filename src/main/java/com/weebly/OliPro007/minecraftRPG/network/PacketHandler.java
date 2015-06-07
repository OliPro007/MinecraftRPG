package com.weebly.OliPro007.minecraftRPG.network;

import com.weebly.OliPro007.minecraftRPG.utilities.References;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {
	
	private static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(References.MODID.toLowerCase());
	
	public static SimpleNetworkWrapper instance(){
		return INSTANCE;
	}
	
	public static void init(){
		INSTANCE.registerMessage(MessageSkillUpdate.class, MessageSkillUpdate.class, 0, Side.CLIENT);
	}

}
