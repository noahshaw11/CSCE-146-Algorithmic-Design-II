/*
 * Written by Noah Shaw
 */
import java.util.Random;
public class Potato {
	
	private Random rand = new Random();
	private static final int MAX = 180; //Max hot potato time
	
	//Instance variables
	private int time;
	
	//Constructors
	public Potato() //Sets the hot potato time
	{
		time = rand.nextInt(MAX + 1);
	}
	
	//Accessors
	public int getTime() //Returns the hot potato time
	{
		return this.time;
	}

}
