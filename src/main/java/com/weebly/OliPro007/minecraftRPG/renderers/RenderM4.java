package com.weebly.OliPro007.minecraftRPG.renderers;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class RenderM4 implements IItemRenderer {

	private static IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("minecraftrpg", "models/guns/kg9_splitted.obj"));
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		model.renderAll();
		GL11.glPopMatrix();
	}

}
