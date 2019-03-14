package Skills.SkillType;

import java.util.Queue;

import org.bukkit.event.block.Action;

public interface ComboSkill extends ExecutableSkill{

	public void addAction(Action a);
	public Queue<Action> getCombo();
	
	
}
