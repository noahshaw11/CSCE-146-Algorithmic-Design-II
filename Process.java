/*
 * Written by Noah Shaw
 */
public class Process {
	
	//Attributes
	private String name;
	private double completionTime;
	
	//Constructors
	public Process()
	{
		this.name = "none";
		this.completionTime = 0.0;
	}
	public Process(String aName, double aCompletionTime)
	{
		this.setName(aName);
		this.setCompletionTime(aCompletionTime);
	}
	
	//Accessors
	public String getName()
	{
		return this.name;
	}
	public double getCompletionTime()
	{
		return this.completionTime;
	}
	
	//Mutators
	public void setName(String aName)
	{
		this.name = aName;
	}
	public void setCompletionTime(double aCompletionTime)
	{
		if(aCompletionTime >= 0.0)
		{
			this.completionTime = aCompletionTime;
		}
	}
	
	//Methods
	public String toString()
	{
		return "Name: " + this.name + " Completion Time: " + this.completionTime;
	}
	

}
