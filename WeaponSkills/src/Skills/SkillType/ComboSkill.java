package Skills.SkillType;

import java.util.List;

import org.bukkit.event.block.Action;

import Skills.ComboSkills.ComboSkillAction;

public interface ComboSkill extends ExecutableSkill{

	public void addAction(Action a);
	public List<ComboSkillAction> getCombo();
	
	
}
