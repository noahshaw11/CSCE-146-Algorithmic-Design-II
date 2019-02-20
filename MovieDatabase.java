/*
 * Written by Noah Shaw
 */
import java.io.*;
import java.util.*;
public class MovieDatabase {
	
	//Generic linked list of Movies
	private GenLinkedList<Movie> movies;
	
	//Delimiter
	public static final String DELIM = "\t";
	public static final int FIELD_AMT = 5;
	
	//Constructor
	public MovieDatabase()
	{
		movies = new GenLinkedList<Movie>();
	}
	
	//Methods
	public void addMovie(Movie aMovie) //Adds a movie to the list
	{
		movies.insert(aMovie);
	}
	public void removeMovie(String aName) //Removes a movie from a list
	{
		movies.resetCurrent();
		while(movies.hasMore() && !(movies.getCurrent().getName().equalsIgnoreCase(aName)))
		{
			movies.goToNext();
		}
		if(movies.getCurrent().getName().equalsIgnoreCase(aName))
		{
			movies.deleteCurrent();
		}
	}
	public void search(String aBase, String aCriteria) //Searches for a movie based on a search base and search criteria
	{
		if(aBase.equalsIgnoreCase("title")) //Title
		{
			movies.resetCurrent();
			while(movies.hasMore())
			{
				if(movies.getCurrent().getName().equalsIgnoreCase(aCriteria))
				{
					System.out.println(movies.getCurrent());
				}
				movies.goToNext();
			}
		}
		else if(aBase.equalsIgnoreCase("director")) //Director
		{
			movies.resetCurrent();
			while(movies.hasMore())
			{
				if(movies.getCurrent().getDirector().equalsIgnoreCase(aCriteria))
				{
					System.out.println(movies.getCurrent());
				}
				movies.goToNext();
			}
		}
	}
	public void search(String aBase, int aCriteria) //Overloaded method for search
	{
		if(aBase.equalsIgnoreCase("year")) //Year
		{
			movies.resetCurrent();
			while(movies.hasMore())
			{
				if(movies.getCurrent().getYear() == aCriteria)
				{
					System.out.println(movies.getCurrent());
				}
				movies.goToNext();
			}
		}
		else if(aBase.equalsIgnoreCase("rating")) //Rating
		{
			movies.resetCurrent();
			while(movies.hasMore())
			{
				if(movies.getCurrent().getRating() == aCriteria)
				{
					System.out.println(movies.getCurrent());
				}
				movies.goToNext();
			}
		}
	}
	public void print() //Prints the list of movies
	{
		movies.print();
	}
	public void writeToFile(String aFileName) //Writes to a file
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aFileName + ".txt"));
			movies.resetCurrent();
			while(movies.hasMore())
			{
				fileWriter.println(movies.getCurrent());
				movies.goToNext();
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void readFromFile(String fileName) //Reads from a file
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName + ".txt"));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLine = fileLine.split(DELIM);
				if(splitLine.length != FIELD_AMT)
				{
					continue;
				}
				this.addMovie(new Movie(splitLine[0], Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4])));
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
