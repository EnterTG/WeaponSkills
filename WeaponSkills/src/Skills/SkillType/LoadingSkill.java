package Skills.SkillType;

public interface LoadingSkill extends ExecutableSkill
{
	
	default void load(int howmuch)
	{
		setLoad(getLoad()+howmuch);
		if(getLoad()+howmuch > getMaxLoad()) execute();
	}
	int getLoad();
	void setLoad(int load);
	public void execute();
	int getMaxLoad();
}
