import java.io.*;
import java.util.*;
public class TacoDB {
	private Taco[] tacos;
	public static final int DEF_SIZE = 128;
	public static final String DELIM = "\t";
	public static final int FIELD_AMT = 3;
	public TacoDB()
	{
		init(DEF_SIZE);
	}
	public TacoDB(int size)
	{
		init(size);
	}
	private void init(int size) //Initialization
	{
		if(size > 0)
			tacos = new Taco[size];
	}
	public void addTaco(Taco aTaco)
	{
		for(int i = 0;i < tacos.length; i++)
		{
			if(tacos[i] == null)
			{
				tacos[i] = aTaco;
				break; //Don't forget this
			}
		}
	}
	public void removeTaco(Taco aTaco)
	{
		int rmIndex = -1;
		for(int i = 0; i < tacos.length; i++)
		{
			if(tacos[i] == null)
				return;
			if(tacos[i].equals(aTaco))
			{
				rmIndex = i;
				break;
			}
		}
		if(rmIndex == -1)
			return;
		for(int i = rmIndex; i < tacos.length - 1; i++)
			tacos[i] = tacos[i+1];
		tacos[tacos.length - 1] = null;
	}
	public void printInfo()
	{
		for(Taco t : tacos)
			if(t != null)
				System.out.println(t);
	}
	public void writeDBFile(String aFileName)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aFileName));
			//Header
			//fileWriter.println("Num Tacos" + DELIM + tacos.length);
			//Body
			for(Taco t : tacos)
			{
				if(t == null)
					break;
				fileWriter.println(t.getName() + DELIM + t.getLocation() + DELIM + t.getPrice());
			}
			fileWriter.close(); //Don't forget
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	/**
	 * 
	 * @param aFileName
	 */
	public void readTacoDBFile(String aFileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aFileName));
			int size = 0;
			while(fileScanner.hasNextLine())
			{
				size++;
				fileScanner.nextLine();
			}
			fileScanner = new Scanner(new File(aFileName));
//			//Read in the header
//			String input = fileScanner.nextLine(); //Read the line
//			String [] splitLine = input.split(DELIM);
//			if(splitLine.length != 2) //Check the line
//				return;
//			//Process it
//			int size = Integer.parseInt(splitLine[1]);
//			this.init(size);
			//Read the body
			while(fileScanner.hasNextLine())
			{
				String input = fileScanner.nextLine();
				String[] splitLine = input.split(DELIM);
				if(splitLine.length != FIELD_AMT)
					continue;
				String name = splitLine[0];
				String loc = splitLine[1];
				double price = Double.parseDouble(splitLine[2]);
				this.addTaco(new Taco(name, loc, price));
			}
			fileScanner.close(); //Don't forget
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
