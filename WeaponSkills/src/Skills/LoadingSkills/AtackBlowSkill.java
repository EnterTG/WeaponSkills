package Skills.LoadingSkills;

import org.bukkit.Particle;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Finders.StandardFinders;
import Main.PlayerWeapons;
import Skills.WeaponSkill;
import Skills.LoadingSkills.Triggers.AtackLoadingSkill;

public class AtackBlowSkill extends WeaponSkill implements AtackLoadingSkill{

	
	private int loadingState = 0;
	private int power ;
	public AtackBlowSkill(PlayerWeapons pw, ItemStack item) {
		super(pw, item);
	}

	@Override
	public void setLoad(int load) {
		loadingState = load;
	}

	@Override
	public void execute() 
	{
		final Player p = playerWeapons.player;
		p.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, p.getLocation(), 1);
		playerWeapons.player.getNearbyEntities(2, 2, 2).stream().filter( e-> e instanceof Monster).map(e -> (Monster)e).forEach(e -> e.damage(power));
		setLoad(0);
	}

	@Override
	public int getMaxLoad() {
		return 6;
	}

	@Override
	public void start() 
	{
		StandardFinders  sf = new StandardFinders("Moc");
		power = (int) sf.find(item);
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
