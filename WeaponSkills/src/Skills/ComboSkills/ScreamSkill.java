package Skills.ComboSkills;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import Main.PlayerWeapons;
import Skills.WeaponSkill;
import Skills.SkillType.ComboSkill;

public class ScreamSkill extends WeaponSkill implements ComboSkill
{
	private static final int comboLenght = 3;
	private List<ComboSkillAction> combo = new ArrayList<ComboSkillAction>(comboLenght);
	private List<ComboSkillAction> currentCombo = new ArrayList<ComboSkillAction>(comboLenght);
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
		if(currentCombo.size() == comboLenght) 
		{
			if(checkConditions()) execute();
			currentCombo.clear();
		}
		
	}

	@Override
	public List<ComboSkillAction> getCombo() {
		return combo;
	}
	
	@Override
	public void start() {
		combo.add(ComboSkillAction.RightClick);
		combo.add(ComboSkillAction.RightClick);
		combo.add(ComboSkillAction.RightClick);
	}

	@Override
	protected boolean checkConditions() 
	{
		for(int i = 0 ; i < comboLenght; i++)
		{
			if(!combo.get(i).equals(currentCombo.get(i))) return false;
		}
		return true;
	}
	
	private Vector calculatePushVector(Location pusched, Location pushing)
	{
		Vector v = new Vector(pushing.getX() - pusched.getX(),pushing.getY() - pusched.getY(), pushing.getZ() - pusched.getZ());
		return v.multiply(1 / pusched.toVector().distance(pushing.toVector())).multiply(-1);
	}

}
