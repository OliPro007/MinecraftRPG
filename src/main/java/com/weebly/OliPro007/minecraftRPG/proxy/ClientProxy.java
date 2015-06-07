package com.weebly.OliPro007.minecraftRPG.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

import com.weebly.OliPro007.minecraftRPG.MinecraftRPG;
import com.weebly.OliPro007.minecraftRPG.entities.EntityBullet;
import com.weebly.OliPro007.minecraftRPG.renderers.RenderBullet;
import com.weebly.OliPro007.minecraftRPG.renderers.RenderM4;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
		MinecraftForgeClient.registerItemRenderer(MinecraftRPG.arMFour, new RenderM4());
	}

}
