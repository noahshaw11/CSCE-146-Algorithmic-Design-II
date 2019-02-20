/*
 * Written by Noah Shaw
 */
public class Movie {
	
	public static final String DELIM = "\t";
	
	//Instance variables
	private String name;
	private int year;
	private int rating;
	private String director;
	private int gross;
	
	//Constructors
	public Movie()
	{
		this.name = "";
		this.year = 0;
		this.rating = 1;
		this.director = "";
		this.gross = 0;
	}
	public Movie(String aName, int aYear, int aRating, String aDirector, int aGross)
	{
		this.setName(aName);
		this.setYear(aYear);
		this.setRating(aRating);
		this.setDirector(aDirector);
		this.setGross(aGross);
	}
	
	//Accessors
	public String getName()
	{
		return this.name;
	}
	public int getYear()
	{
		return this.year;
	}
	public int getRating()
	{
		return this.rating;
	}
	public String getDirector()
	{
		return this.director;
	}
	public int getGross()
	{
		return this.gross;
	}
	
	//Mutators
	public void setName(String aName)
	{
		this.name = aName;
	}
	public void setYear(int aYear)
	{
		if(this.year >= 0)
		{
			this.year = aYear;
		}
	}
	public void setRating(int aRating)
	{
		if(aRating >= 1 && aRating <= 5)
		{
			this.rating = aRating;
		}
		else
		{
			this.rating = 1;
		}
	}
	public void setDirector(String aDirector)
	{
		this.director = aDirector;
	}
	public void setGross(int aGross)
	{
		this.gross = aGross;
	}
	
	//Methods
	public boolean equals(Movie aMovie)
	{
		return aMovie != null &&
				this.name.equalsIgnoreCase(aMovie.getName()) &&
				this.year == aMovie.getYear() &&
				this.rating == aMovie.getRating() &&
				this.director.equalsIgnoreCase(aMovie.getDirector()) &&
				this.gross == aMovie.getGross();
	}
	public boolean compareTo(Movie aMovie)
	{
		if(aMovie == null)
		{
			return false;
		}
		return true;
	}
	public String toString()
	{
		return this.name + DELIM + this.year + DELIM + this.rating + DELIM + this.director + DELIM + this.gross;
	}

}
