package Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Main.PlayerWeapons;
import Main.PlayersWeaponsManager;

public class PlayerJoinListener implements Listener{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		PlayerWeapons pw = new PlayerWeapons(e.getPlayer());
		PlayersWeaponsManager.getPlayersWeaponsManager().addPlayer(e.getPlayer(), pw);
		pw.scanItems();
	}

}
