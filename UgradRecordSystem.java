import java.io.*;
import java.util.*;
public class UgradRecordSystem {
	
	public static final String DELIM = "\t";
	
	/*
	 * Static can call static
	 * Non-static can call static
	 * Static CANNOT call non-static
	 */
	public static void writeToFile(String fileName, Ugrad[] uGrads)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			//<<name>>\t<<id>>\t<<level??\n
			for(Ugrad u: uGrads)
			{
				fileWriter.println(u.getName() + DELIM + u.getId() + DELIM + u.getLevel());
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static Ugrad[] readFromFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			//First pass: count each endline
			int count = 0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.hasNextLine();
				count++;
			}
			Ugrad[] retU = new Ugrad[count];
			//Second pass: process each line
			fileScanner = new Scanner(new File(fileName)); //Reset the scanner
			count = 0;
			while(fileScanner.hasNextLine())
			{
				//Read the line
				String line = fileScanner.nextLine();
				//Split the line
				String[] splitStr = line.split(DELIM);
				if(splitStr.length != 3) //Check the line
					continue;
				retU[count] = new Ugrad(splitStr[0], Integer.parseInt(splitStr[1]), Integer.parseInt(splitStr[2]));
				count++;
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
