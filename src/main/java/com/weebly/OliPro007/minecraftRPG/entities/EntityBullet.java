package com.weebly.OliPro007.minecraftRPG.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.weebly.OliPro007.minecraftRPG.items.Bullet;

public class EntityBullet extends EntityThrowable implements IProjectile{

	//private static final float explosionRadius = 0.75F;
	private static Bullet bulletType;

	public EntityBullet(World par1World) {
		super(par1World);
        this.setSize(0.5F, 0.5F);
	}	

	public EntityBullet(World par1World, EntityPlayer par2EntityLivingBase, Bullet bulletType) {
		super(par1World, par2EntityLivingBase);
		this.bulletType = bulletType;
		this.motionX *= bulletType.getBulletType().getSpeed();
		this.motionY *= bulletType.getBulletType().getSpeed();
		this.motionZ *= bulletType.getBulletType().getSpeed();
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, 3.0F, 1.0F);
        this.setSize(0.5F, 0.5F);
	}
	
	public EntityBullet(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
		this.setSize(0.5F, 0.5F);
	}

	@Override
	public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
		super.setThrowableHeading(par1, par3, par5, par7, par8);
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		int x = movingobjectposition.blockX;
		int y = movingobjectposition.blockY;
		int z = movingobjectposition.blockZ;
		if(worldObj.getBlock(x, y, z) == Blocks.tnt){
			worldObj.setBlockToAir(x, y, z);
			EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(worldObj, (double)((float) x + 0.5F), (double)((float) y + 0.5F), (double)((float) z + 0.5F), this.getThrower());
			worldObj.spawnEntityInWorld(entitytntprimed);
		}
		if(worldObj.getBlock(x, y, z) == Blocks.glass || worldObj.getBlock(x, y, z) == Blocks.glass_pane){
			worldObj.setBlockToAir(x, y, z);
			worldObj.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "random.glass", 1.0F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}
		if(movingobjectposition.entityHit != null){			
			movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), bulletType.getBulletType().getDamage());
		}
		//this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);
		this.setDead();
	}
	
	@Override
	protected float getGravityVelocity(){
		return 0;
	}

}
