/*
 * Written by Noah Shaw
 */
public class Prize {
	
	//Instance variables
	private String name;
	private double price;
	
	//Constructors
	public Prize()
	{
		this.price = 0.0;
		this.name = "none";
	}
	public Prize(String aName, double aPrice)
	{
		this.setName(aName);
		this.setPrice(aPrice);
	}
	
	//Accessors
	public String getName()
	{
		return this.name;
	}
	public double getPrice()
	{
		return this.price;
	}
	
	//Mutators
	public void setName(String aName)
	{
		this.name = aName;
	}
	public void setPrice(double aPrice)
	{
		if(aPrice >= 0.0)
		{
			this.price = aPrice;
		}
	}

}
