package Skills;


import org.bukkit.inventory.ItemStack;

import Main.PlayerWeapons;

public abstract class WeaponSkill 
{
	protected PlayerWeapons playerWeapons;
	protected ItemStack item;
	public WeaponSkill(PlayerWeapons pw,ItemStack item)
	{
		playerWeapons = pw;
		this.item =  item;
	}
	public abstract void start();
	public  void stop()
	{
		playerWeapons.removeWeaponSkill(this);
	}
	protected abstract boolean checkConditions();
}
