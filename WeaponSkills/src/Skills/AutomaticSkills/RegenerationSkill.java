package Skills.AutomaticSkills;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import Finders.Finder;
import Finders.StandardFinders;
import Main.Core;
import Main.PlayerWeapons;
import Skills.WeaponSkill;
import Skills.SkillType.AutomaticSkill;

public class RegenerationSkill extends WeaponSkill implements AutomaticSkill{

	private boolean active = true;
	private double regenAmount = 0d;
	private static BukkitScheduler BUKKIT_SCHEDULER; 
	private static final Finder finder = new StandardFinders("Leczy");
	public RegenerationSkill(PlayerWeapons pw,ItemStack item) {
		super(pw,item);
		regenAmount = finder.find(item);
		if(BUKKIT_SCHEDULER == null)BUKKIT_SCHEDULER = Bukkit.getScheduler();
	}

	@Override
	public int getCoolDown() {
		return 60;
	}

	@Override
	public void execute() 
	{
		if(checkConditions()) 
		{
			healPlayer(regenAmount);
		}
		if(active)BUKKIT_SCHEDULER.runTaskLaterAsynchronously(Core.getCore(), this, getCoolDown());
		
	}

	@Override
	public void start() {
		Bukkit.getScheduler().runTaskLaterAsynchronously(Core.getCore(), this, getCoolDown());
	}

	@Override
	public void stop() {
		super.stop();
		active = false;
	}
	
	@Override
	protected boolean checkConditions() 
	{
		Player p = playerWeapons.player;
		return !p.isDead() && (p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() > p.getHealth());
	}
	
	private void healPlayer(double amount)
	{
		Player p = playerWeapons.player;
		
		if( p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() < (p.getHealth()+amount) ) 
				p.setHealth(p.getHealth()+amount); 
		else
				p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()); 
		
	}

}
