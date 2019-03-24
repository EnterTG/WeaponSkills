package Skills.ComboSkills;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.bukkit.Location;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import Main.PlayerWeapons;
import Skills.WeaponSkill;
import Skills.SkillType.ComboSkill;

public class ScreamSkill extends WeaponSkill implements ComboSkill{
	private Queue<ComboSkillAction> combo = new ArrayBlockingQueue<ComboSkillAction>(3);
	private Queue<ComboSkillAction> currentCombo = new ArrayBlockingQueue<ComboSkillAction>(3);
	public ScreamSkill(PlayerWeapons pw, ItemStack item) {
		super(pw, item);
	}

	@Override
	public void execute() 
	{
		final Player p = playerWeapons.player;
		final Location loc = p.getLocation();
		p.getNearbyEntities(3, 3, 3).stream().filter(e -> e instanceof Monster).forEach(e -> e.setVelocity(calculatePushVector(e.getLocation(),loc)));;
	}

	@Override
	public void addAction(Action a) 
	{
		if(a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK) currentCombo.add(ComboSkillAction.LeftClick);
		else currentCombo.add(ComboSkillAction.RightClick);
	}

	@Override
	public Queue<ComboSkillAction> getCombo() {
		return combo;
	}
	
	@Override
	public void start() {
		combo.add(ComboSkillAction.RightClick);
		combo.add(ComboSkillAction.RightClick);
		combo.add(ComboSkillAction.RightClick);
	}

	@Override
	protected boolean checkConditions() {
		return currentCombo.equals(combo);
	}
	
	private Vector calculatePushVector(Location pusched, Location pushing)
	{
		Vector v = new Vector(pushing.getX() - pusched.getX(),pushing.getY() - pusched.getY(), pushing.getZ() - pusched.getZ());
		return v.multiply(1 / pusched.toVector().distance(pushing.toVector()));
	}

}
