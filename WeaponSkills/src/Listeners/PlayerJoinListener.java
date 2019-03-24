package Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e)
	{
		PlayersWeaponsManager.getPlayersWeaponsManager().removePlayer(e.getPlayer());
	}

}
