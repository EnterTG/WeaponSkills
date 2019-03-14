package Listeners;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Main.PlayerWeapons;
import Main.PlayersWeaponsManager;
import Skills.WeaponSkill;
import Skills.SkillType.ComboSkill;

public class PlayerInteractListener implements Listener
{
	private static final PlayerWeapons.Checker checker = (k) -> k instanceof ComboSkill;
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e)
	{
		PlayerWeapons pw = PlayersWeaponsManager.getPlayersWeaponsManager().getPlayerWeopons(e.getPlayer());
		List<WeaponSkill> skills = pw.getWeaponSkill(checker);
		Action a = e.getAction();
		skills.forEach(s -> ((ComboSkill)s).addAction(a));
	}
}
