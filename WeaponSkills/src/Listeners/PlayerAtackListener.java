package Listeners;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import Main.PlayerWeapons;
import Main.PlayersWeaponsManager;
import Skills.WeaponSkill;
import Skills.LoadingSkills.Triggers.AtackLoadingSkill;

public class PlayerAtackListener implements Listener{

	private static final PlayerWeapons.Checker checker = (k) -> k instanceof AtackLoadingSkill;
	
	@EventHandler
	public void onPlayerAtackEvent(EntityDamageByEntityEvent e)
	{
		if(e.getDamager() instanceof Player)
		{
			Player p = (Player) e.getDamager();
			PlayerWeapons pw = PlayersWeaponsManager.getPlayersWeaponsManager().getPlayerWeopons(p);
			List<WeaponSkill> skills = pw.getWeaponSkill(checker);
			skills.forEach(s -> ((AtackLoadingSkill)s).load(1));
		}
	}
}
