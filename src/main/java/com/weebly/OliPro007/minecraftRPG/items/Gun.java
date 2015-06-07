package com.weebly.OliPro007.minecraftRPG.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.weebly.OliPro007.minecraftRPG.entities.EntityBullet;

public class Gun extends ModItem{

	private static Magazine magType;
	
	public Gun(Magazine magType, CreativeTabs tab, String name) {
		this.magType = magType;
		this.setCreativeTab(tab);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		int slot = verifyMag(par3EntityPlayer);
		if(par3EntityPlayer.capabilities.isCreativeMode || slot != 0){
			if(!(par3EntityPlayer.capabilities.isCreativeMode)){
				par3EntityPlayer.inventory.getStackInSlot(slot).damageItem(1, par3EntityPlayer);
			}
			par2World.playSoundAtEntity(par3EntityPlayer, "minecraftrpg:m4_shoot", 0.75F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!par2World.isRemote){
				par2World.spawnEntityInWorld(new EntityBullet(par2World, par3EntityPlayer, magType.getBullet()));
			}
		}else{
			par2World.playSoundAtEntity(par3EntityPlayer, "minecraftrpg:m4_empty", 0.25F, 0.3F / (itemRand.nextFloat() * 0.3F + 0.5F));
		}
		return par1ItemStack;
	}
	
	private int verifyMag(EntityPlayer player){
		int slot = 0;
		for(int i=0; i<player.inventory.getSizeInventory(); i++){
			ItemStack stack = player.inventory.getStackInSlot(i);
			if(stack != null){
				if(stack.getItem() == this.magType){
					if(stack.getItemDamage() < stack.getMaxDamage()){
						slot = i;
						break;
					}					
				}
			}
		}
		return slot;
	}

}
