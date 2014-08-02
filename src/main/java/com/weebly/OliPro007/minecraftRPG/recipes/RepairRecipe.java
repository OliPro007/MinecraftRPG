package com.weebly.OliPro007.minecraftRPG.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RepairRecipe implements IRecipe{
	
	private int repairAmount;
	private Item toRepair;
	private ItemStack repairMaterial;
	
	public RepairRecipe(Item toRepair, ItemStack repairMaterial, int repairAmount){
		this.toRepair = toRepair;
		this.repairMaterial = repairMaterial;
		this.repairAmount = repairAmount;
	}

	@Override
	public boolean matches(InventoryCrafting inventory, World world) {
		int count = 0;
		
		for(int i=0; i<inventory.getSizeInventory(); i++){
			ItemStack stack = inventory.getStackInSlot(i);
			if(stack != null){
				if(stack.getItem() == this.toRepair){
					count++;
				}
				if(stack.getItem() == this.repairMaterial.getItem() && stack.getItemDamage() == this.repairMaterial.getItemDamage()){
					count++;
				}
			}
		}
		
		return (count >= 2);
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory) {
		ItemStack repair = null;
		int count = 0;
		int damage = 0;
		
		for(int i=0; i<inventory.getSizeInventory(); i++){
			ItemStack stack = inventory.getStackInSlot(i);
			if(stack != null){
				if(stack.getItem() == this.toRepair){
					repair = stack;
					damage = repair.getItemDamage();
				}
				if(stack.getItem() == this.repairMaterial.getItem() && stack.getItemDamage() ==this.repairMaterial.getItemDamage()){
					count++;
				}
			}
		}
		
		int rep = count * this.repairAmount;
		
		if(damage - rep < (-this.repairAmount + 2)){
			return null;
		}
		return (new ItemStack(this.toRepair, 1, damage - rep));
	}

	@Override
	public int getRecipeSize() {
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

}
