package Main;


import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Listeners.PlayerAtackListener;
import Listeners.PlayerChangeSlotListener;
import Listeners.PlayerCloseInventoryListener;
import Listeners.PlayerInteractListener;
import Listeners.PlayerJoinListener;
import Listeners.PlayerMoveListener;

public class Core extends JavaPlugin{

	private static Core core;
	public static Core getCore()
	{return core;}
	
	public Core()
	{
		
	}
	
	@Override
	public void onEnable()
	{
		core = this;
		
		//Register listeners
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new PlayerCloseInventoryListener(), this);
		pm.registerEvents(new PlayerInteractListener(), this);
		pm.registerEvents(new PlayerJoinListener(), this);
		pm.registerEvents(new PlayerMoveListener(), this);
		pm.registerEvents(new PlayerAtackListener(), this);
		pm.registerEvents(new PlayerChangeSlotListener(), this);
	}
	
	@Override
	public void onDisable()
	{
		
	}

}
