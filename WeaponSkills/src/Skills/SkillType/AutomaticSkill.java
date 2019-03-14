package Skills.SkillType;

public interface AutomaticSkill extends Runnable,ExecutableSkill{
	
	default void run()
	{
		execute();
	}
	
	int getCoolDown();
	void execute();
}
