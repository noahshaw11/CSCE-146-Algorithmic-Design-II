/*
 * Written by Noah Shaw
 */
public class Player {
	
	//Instance variables
	private String name;
	private int possession;
	
	//Constructor
	public Player()
	{
		name = "none";
		possession = 0;
	}
	public Player(String aName, int aPossession)
	{
		this.setName(aName);
		this.setPossession(aPossession);
	}
	
	//Accessors
	public String getName()
	{
		return this.name;
	}
	public int getPossession()
	{
		return this.possession;
	}
	
	//Mutators
	public void setName(String aName)
	{
		this.name = aName;
	}
	public void setPossession(int aPossession)
	{
		this.possession = aPossession;
	}

}
