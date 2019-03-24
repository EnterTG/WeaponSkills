package Skills.SkillType;

import java.util.Queue;

import org.bukkit.event.block.Action;

import Skills.ComboSkills.ComboSkillAction;

public interface ComboSkill extends ExecutableSkill{

	public void addAction(Action a);
	public Queue<ComboSkillAction> getCombo();
	
	
}
