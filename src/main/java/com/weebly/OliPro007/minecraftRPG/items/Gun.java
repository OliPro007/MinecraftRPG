package com.weebly.OliPro007.minecraftRPG.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.weebly.OliPro007.minecraftRPG.entities.EntityBullet;

public class Gun extends Item{

	private static Magazine magType;
	
	public Gun(Magazine magType, CreativeTabs tab, String texture, String name) {
		this.magType = magType;
		this.setCreativeTab(tab);
		this.setTextureName(texture);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		
		if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(magType.getBullet())){
			par2World.playSoundAtEntity(par3EntityPlayer, "minecraftrpg:m4_shoot", 0.75F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!par2World.isRemote){
				par2World.spawnEntityInWorld(new EntityBullet(par2World, par3EntityPlayer, magType.getBullet()));
			}
		}else{
			par2World.playSoundAtEntity(par3EntityPlayer, "minecraftrpg:m4_empty", 0.25F, 0.3F / (itemRand.nextFloat() * 0.3F + 0.5F));
		}
		return par1ItemStack;
	}

}
