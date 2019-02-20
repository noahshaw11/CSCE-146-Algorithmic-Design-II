
public class Student extends Person {
	private int id;
	public Student()
	{
		super(); //Calls Person's default constructor
		this.id = 0;
	}
	public Student(String aName, int anId)
	{
		super(aName);
		this.setId(anId);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}
	public String toString()
	{
		return super.toString() + "ID: " + this.id;
	}
	public boolean equals(Student s)
	{
		return s != null &&
				super.equals(s) &&
				this.id == s.getId();
	}

}
