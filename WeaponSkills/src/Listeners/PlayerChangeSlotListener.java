package Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import Main.PlayersWeaponsManager;

public class PlayerChangeSlotListener implements Listener{

	@EventHandler
	public void onPlayerChangeSlot(PlayerItemHeldEvent e)
	{
		PlayersWeaponsManager.getPlayersWeaponsManager().getPlayerWeopons(e.getPlayer()).scanItems();
	}
	@EventHandler
	public void onPlayerChangeMainHand(PlayerSwapHandItemsEvent e)
	{
		PlayersWeaponsManager.getPlayersWeaponsManager().getPlayerWeopons(e.getPlayer()).scanItems();
	}
}
