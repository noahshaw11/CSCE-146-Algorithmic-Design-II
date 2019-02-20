/*
 * Written by Noah Shaw
 */
import java.util.Scanner;
public class ShowcaseGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a showcase
		boolean gameOver = false;
		//Game loop
		while(gameOver != true)
		{
			//Greeting
			System.out.println("Welcome to the showcase showdown!"
					+ "\nYour prizes are: ");
			//Construct the showcase and print it
			Showcase showcase = new Showcase();
			//Get the player's guess
			System.out.println("You must guess the total cost of all items without going over!"
					+ "\nPlease enter your guess:");
			Scanner keyboard = new Scanner(System.in);
			double guess = keyboard.nextDouble();
			System.out.println("Your guess was " + guess + " and the actual price was " + showcase.addShowcase());
			//Check the guess
			if(guess <= showcase.addShowcase())
			{
				if(guess >= showcase.addShowcase() - 2000)
				{
					System.out.println("Your guess was under! You win!");
				}
				else
				{
					System.out.println("That guess was WAY off! You lose!");
				}
			}
			else if(guess > showcase.addShowcase())
			{
				System.out.println("That guess was over! You lose!");
			}
			//Ask if the player wants to play again
			System.out.println("Would you like to play again? Enter 'no' to quit.");
			keyboard.nextLine();
			//Play again or end game
			if(keyboard.nextLine().equalsIgnoreCase("no"))
			{
				gameOver = true;
				System.out.println("Thanks for playing!");
			}
		}

	}

}
