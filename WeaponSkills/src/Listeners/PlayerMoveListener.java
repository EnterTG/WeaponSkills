package Listeners;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import Main.PlayerWeapons;
import Main.PlayersWeaponsManager;
import Skills.WeaponSkill;
import Skills.LoadingSkills.Triggers.MovementSkill;

public class PlayerMoveListener implements Listener{

	private static final PlayerWeapons.Checker checker = (k) -> k instanceof MovementSkill;
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e)
	{
		PlayerWeapons pw = PlayersWeaponsManager.getPlayersWeaponsManager().getPlayerWeopons(e.getPlayer());
		List<WeaponSkill> skills = pw.getWeaponSkill(checker);
		skills.forEach(s -> ((MovementSkill)s).load(1));
	}
	
}
