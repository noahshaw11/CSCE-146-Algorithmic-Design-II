
public class Ugrad extends Student {
	private int level; //1-fresh 2-soph 3-jun 4-sen 5-ssgss
	public Ugrad()
	{
		super();
		this.level = 1;
	}
	public Ugrad(String aName, int anId, int aLvl)
	{
		super(aName, anId);
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level >= 1 && level <= 5)
			this.level = level;
		else
			this.level = 1;
	}
	public String toString()
	{
		return super.toString() + "Level: " + this.level;
	}
	public boolean equals(Ugrad u)
	{
		return u != null &&
				super.equals(u) &&
				this.level == u.getLevel();
	}

}
