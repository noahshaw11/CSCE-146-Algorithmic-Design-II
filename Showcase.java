/*
 * Written by Noah Shaw
 */
import java.io.*;
import java.util.Random;
import java.util.*;
public class Showcase {
	
	//Constants
	public static final int MAX_PRIZES = 50;
	public static final int MAX_SHOWCASE = 5;
	public static final String DELIM = "\t";
	public static final int FIELD_AMT = 2;
	public static final String FILE_NAME = "./prizeList.txt";
	
	//Instance variable
	private Prize[] prizes;
	private Prize[] showcase;
	
	//Constructor
	public Showcase()
	{
		showcase = new Prize[MAX_SHOWCASE];
		prizes = new Prize[MAX_PRIZES];
		readPrizeList(FILE_NAME);
		populate();
		printShowcase();
	}
	
	//Method to randomly populate the showcase array
	public void populate()
	{
		Random r = new Random();
		for(int i = 0; i < showcase.length; i++)
		{
			int index = r.nextInt(MAX_PRIZES);
			if(prizes[index] != null)
			{
				showcase[i] = prizes[index];
			}
		}
	}
	
	//Method to add a prize to the prize array
	public void addPrize(Prize aPrize)
	{
		for(int i = 0;i < prizes.length; i++)
		{
			if(prizes[i] == null)
			{
				prizes[i] = aPrize;
				break;
			}
		}
	}
	
	//Method to print the showcase to the console
	public void printShowcase()
	{
		for(Prize p : showcase)
		{
			if(p != null)
			{
				System.out.println(p.getName());
			}
		}
	}
	
	//Method that reads the file and populates the prize array
	public Prize[] readPrizeList(String aFileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aFileName));
			while(fileScanner.hasNextLine())
			{
				String input = fileScanner.nextLine();
				String[] splitLine = input.split(DELIM);
				if(splitLine.length != FIELD_AMT)
				{
					continue;
				}
				addPrize(new Prize(splitLine[0], Double.parseDouble(splitLine[1])));
			}
			fileScanner.close();
			return prizes;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	//Add up all of the item's prices in the showcase
	public double addShowcase()
	{
		double sum = 0.0;
		for(Prize p : showcase)
		{
			sum += p.getPrice();
		}
		return sum;
	}

}
