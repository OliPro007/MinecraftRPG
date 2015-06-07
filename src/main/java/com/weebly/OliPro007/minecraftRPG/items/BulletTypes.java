package com.weebly.OliPro007.minecraftRPG.items;


public enum BulletTypes {
	
	//PISTOL("9mmAmmo", 3.0F),
	//SMG("smgAmmo", 4.0F),
	AR("arAmmo", 5.0F, 5.0D);
	//SNIPER("sniperAmmo", 10.0F);
	
	private String name;
	private String texture;
	private float damage;
	private double speed;
	
	private BulletTypes(String name, float damage, double speed){
		this.name = name;
		this.damage = damage;
		this.speed = speed;
	}

	public String getName() {
		return this.name;
	}

	public float getDamage() {
		return this.damage;
	}

	public double getSpeed() {
		return this.speed;
	}
	
}
