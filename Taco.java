
public class Taco {
	//Instance variables are attributes
	private String name;
	private String loc;
	private double price;
	
	//Constructors
	public Taco()
	{
		this.name = this.loc = "none";
		this.price = 0.0;;
	}
	public Taco(String aName, String aLoc, double aPrice)
	{
		//TODO Fill in mutators
		this.setName(aName);
		this.setLocation(aLoc);
		this.setPrice(aPrice);
	}
	
	//Accessors
	public String getName()
	{
		return this.name;
	}
	public String getLocation()
	{
		return this.loc;
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
	public void setLocation(String aLoc)
	{
		this.loc = aLoc;
	}
	public void setPrice(double aPrice)
	{
		if(aPrice >= 0.0)
			this.price = aPrice;
	}
	
	//Methods
	public String toString()
	{
		return this.name + " " + this.loc + " " + this.price;
	}
	public boolean equals(Taco aTaco)
	{
		return aTaco != null &&
				this.name.equalsIgnoreCase(aTaco.getName()) &&
				this.loc.equalsIgnoreCase(aTaco.getLocation()) &&
				this.price == aTaco.getPrice();
	}
	

}
