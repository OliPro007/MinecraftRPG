package com.weebly.OliPro007.minecraftRPG.proxy;

import com.weebly.OliPro007.minecraftRPG.entities.EntityBullet;
import com.weebly.OliPro007.minecraftRPG.renderers.RenderBullet;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
	}

}
