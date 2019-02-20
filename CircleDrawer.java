import java.io.*;
import java.util.*;
public class CircleDrawer {
	
	public static final String DELIM = "\t";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeToFile(CircleDrawer.makePoints(10,  20,  30,  40), "Circle.txt");

	}
	public static void writeToFile(Point[] points, String fileName)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			for(Point p : points)
			{
				fileWriter.println(p.getX() + DELIM + p.getY());
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static Point[] makePoints(double x, double y, double r, int numP)
	{
		if(numP <= 0)
			return null;
		Point[] retP = new Point[numP];
		for(int i = 0; i < numP; i++)
		{
			retP[i] = new Point(x + Math.cos((double)i/(double)numP) * Math.PI * 2, y + Math.sin((double)i/(double)numP) * Math.PI * 2);
		}
		return retP;
	}
	public static Point[] readFromFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			int count = 0;
			while(fileScanner.hasNextLine())
			{
				count++;
				fileScanner.hasNextLine();
			}
			fileScanner = new Scanner(new File(fileName));
			Point[] retP = new Point[count];
			count = 0;
			while(fileScanner.hasNextLine())
			{
				String line = fileScanner.nextLine();
				String[] splitLine = line.split(DELIM);
				if(splitLine.length != 2)
					continue;
				retP[count++] = new Point(Double.parseDouble(splitLine[0]), Double.parseDouble(splitLine[1]));
			}
			fileScanner.close();
			return retP;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

}
