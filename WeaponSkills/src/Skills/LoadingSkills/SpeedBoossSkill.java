package Skills.LoadingSkills;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Finders.StandardFinders;
import Main.PlayerWeapons;
import Skills.WeaponSkill;
import Skills.LoadingSkills.Triggers.MovementSkill;

public class SpeedBoossSkill extends WeaponSkill implements MovementSkill {

	private int loadingState = 0;
	
	private PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 30, 1);
	
	public SpeedBoossSkill(PlayerWeapons pw, ItemStack item) {
		super(pw, item);
	}

	@Override
	public void setLoad(int load) {
		loadingState = load;
	}

	@Override
	public void execute() 
	{
		playerWeapons.player.addPotionEffect(effect);
	}

	@Override
	public int getMaxLoad() {
		return 120;
	}

	@Override
	public void start() 
	{
		StandardFinders  sf = new StandardFinders("Czas");
		sf.find(item);
		
	}

	@Override
	public void stop() 
	{
		super.stop();
	}

	@Override
	protected boolean checkConditions() {
		return true;
	}

	@Override
	public int getLoad() {
		return loadingState;
	}

}
