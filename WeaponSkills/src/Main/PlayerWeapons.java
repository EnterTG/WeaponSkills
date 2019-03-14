package Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import Skills.WeaponSkill;

public class PlayerWeapons
{
	public Player player;
	private Map<ItemStack,WeaponSkill> weaponSkills = new HashMap<>();
	
	public PlayerWeapons(Player p)
	{
		player = p;
	}
	
	public void scanItems()
	{
		PlayerInventory inv = player.getInventory();
		ItemStack[] items = (ItemStack[])Arrays.copyOf(inv.getArmorContents(),inv.getArmorContents().length + 1);
		items[4] = inv.getItemInMainHand();
		weaponSkills.clear();
		for(ItemStack i : items)
		{
			if(i == null) continue;
			WeaponSkill w = SkillFinder.findSkill(this, i);
			if(w!= null)
			{
				weaponSkills.put(i, w);
				w.start();
			}
		}
	}
	public interface Checker
	{
		public boolean isGood(WeaponSkill ws);
	}
	public List<WeaponSkill> getWeaponSkill(Checker c)
	{
		return weaponSkills.values().stream().filter(e -> c.isGood(e)).collect(Collectors.toList());
	}
	
	public synchronized void removeWeaponSkill(WeaponSkill ws)
	{
		weaponSkills.entrySet().stream().filter(e -> e.getValue().equals(ws)).forEach( e -> weaponSkills.remove(e.getKey()));
	}
}
