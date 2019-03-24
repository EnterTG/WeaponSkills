package Main;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class PlayersWeaponsManager {

	public Map<Player,PlayerWeapons> playersWeapons = new HashMap<>();
	private static PlayersWeaponsManager playersWeaponsManager;
	
	private PlayersWeaponsManager()
	{
		
	}
	
	public static PlayersWeaponsManager getPlayersWeaponsManager()
	{
		if(playersWeaponsManager == null) playersWeaponsManager = new PlayersWeaponsManager();
		return playersWeaponsManager;
		
	}
	
	public void addPlayer(Player p, PlayerWeapons pw)
	{
		playersWeapons.put(p, pw);
	}
	
	public PlayerWeapons getPlayerWeopons(Player p)
	{
		return playersWeapons.get(p);
	}
	public void removePlayer(Player p)
	{
		playersWeapons.remove(p);
	}
}
