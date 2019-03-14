package Listeners;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import Main.PlayerWeapons;
import Main.PlayersWeaponsManager;



public class PlayerCloseInventoryListener implements Listener{

	@EventHandler
	public void onPlayerCloseInventory(InventoryCloseEvent e)
	{
		HumanEntity p  = e.getPlayer();
		PlayerWeapons pw = PlayersWeaponsManager.getPlayersWeaponsManager().getPlayerWeopons((Player)p);
		pw.scanItems();
	}

}
