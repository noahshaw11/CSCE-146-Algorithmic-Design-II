
public class Person {
	private String name;
	public Person()
	{
		this.name = "none yet";
	}
	public Person(String aName)
	{
		this.setName(aName);
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String aName)
	{
		this.name = aName;
	}
	public String toString()
	{
		return this.name;
	}
	public boolean equals(Person p)
	{
		return p != null &&
				this.name.equalsIgnoreCase(p.getName());
	}

}
