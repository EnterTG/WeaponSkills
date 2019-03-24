package Main;

import java.util.List;
import java.util.stream.Stream;

import org.bukkit.inventory.ItemStack;

import Skills.WeaponSkill;
import Skills.AutomaticSkills.RegenerationSkill;
import Skills.ComboSkills.ScreamSkill;
import Skills.LoadingSkills.AtackBlowSkill;
import Skills.LoadingSkills.SpeedBoossSkill;

public class SkillFinder {
	
	private enum WeaponsSkills
	{
		Regeneration("--Skill Regeneracji--", (pw,i) -> new RegenerationSkill(pw,i)),
		Scream("--Skill Krzyk--", (pw,i) -> new ScreamSkill(pw,i)),
		Blow("--Skill uderzenie--", (pw,i) -> new AtackBlowSkill(pw,i)),
		FastBoots("--Sybkie buty--", (pw,i) -> new SpeedBoossSkill(pw,i));
		
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
