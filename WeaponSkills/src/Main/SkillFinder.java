package Main;

import java.util.List;
import java.util.stream.Stream;

import org.bukkit.inventory.ItemStack;

import Skills.WeaponSkill;
import Skills.AutomaticSkills.RegenerationSkill;

public class SkillFinder {
	
	private enum WeaponsSkills
	{
		Regeneration("--Skill Regeneracji--", (pw,i) -> new RegenerationSkill(pw,i));
		
		private SkillGeter weaponSkill;
		private String name;
		WeaponsSkills(String n,SkillGeter sg)
		{
			weaponSkill = sg;
			name = n;
		}
		
		private boolean find(ItemStack item)
		{
			List<String> lore = item.getItemMeta().getLore();
			return lore.stream().filter(s -> s.contains(name)).findFirst().isPresent();
		}
		
		private WeaponSkill getWeaponSkill(PlayerWeapons pw,ItemStack item)
		{
			return weaponSkill.getWeaponSkill(pw, item);
		}
	}
	@FunctionalInterface
	private interface SkillGeter
	{
		public WeaponSkill getWeaponSkill(PlayerWeapons pw,ItemStack item);
	}

	
	public static WeaponSkill findSkill(PlayerWeapons pw,ItemStack item)
	{
		return Stream.of(WeaponsSkills.values()).filter(ws -> ws.find(item)).findFirst().orElse(null).getWeaponSkill(pw, item);
	}
}
