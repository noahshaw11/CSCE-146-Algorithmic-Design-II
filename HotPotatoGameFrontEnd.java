/*
 * Written by Noah Shaw
 */
import java.util.Scanner;
public class HotPotatoGameFrontEnd {
	
	public static PlayerCircularLinkedList players;
	public static Potato potato;
	public static Scanner keyboard;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Greeting
		System.out.println("Welcome to the Hot Potato Game!");
		boolean gameOver = false;
		//Game loop
		while(!gameOver)
		{
			//Construct a player list and a potato
			players = new PlayerCircularLinkedList();
			potato = new Potato();
			keyboard = new Scanner(System.in);
			//Prompt for number of players
			System.out.println("\nEnter the number of players (2 or more required).");
			int numOfPlayers = keyboard.nextInt();
			keyboard.nextLine();
			//Prompt for names of the players
			if(numOfPlayers >= 2)
			{
				for(int i = 1; i <= numOfPlayers; i++)
				{
					System.out.println("Enter the player " + i + "'s name.");
					players.insert(new Player(keyboard.nextLine(), 0));
				}
			}
			else
			{
				System.out.println("Not enough players. Ending the game.");
				System.exit(0);
			}
			int timeHeld = 0;
			int timeRemaining = potato.getTime();
			//Round loop (until only one player left)
			while(numOfPlayers > 1)
			{
				//Prompt for time that each player wants to hold the potato
				for(int i = 1; i <= numOfPlayers; i++)
				{
					System.out.println(players.getDataAtCurrent().getName() + " enter a number from 1-10 corresponding to the number of seconds to hold the potato.");
					timeHeld = keyboard.nextInt();
					if(!(timeHeld >= 1 && timeHeld <= 10))
					{
						System.out.println("The number must be between 1 and 10. We will assume you meant 10.");
						timeHeld = 10;
					}
					//Determine if time held by each player is greater than the hot potato time
					if(timeHeld < timeRemaining)
					{
						System.out.println(players.getDataAtCurrent().getName() + " is safe for now!\n");
						timeRemaining = timeRemaining - timeHeld;
						players.goToNext();
					}
					else
					{
						System.out.println("HOT POTATO! " + players.getDataAtCurrent().getName() + " has been eliminated!\n");
						players.deleteCurrent();
						numOfPlayers--;
						timeRemaining = potato.getTime();
						break;
					}
				}
			}
			//State the winner of the game
			System.out.println(players.getDataAtCurrent().getName() + " wins the game!");
			gameOver = true;
			//Prompt the user if they want to play again
			System.out.println("\nWould you like to play again? Yes or no.");
			keyboard.nextLine();
			String playAgain = keyboard.nextLine();
			if(playAgain.equalsIgnoreCase("yes"))
			{
				System.out.println("GOOD LUCK!");
				gameOver = false;
			}
			else if (playAgain.equalsIgnoreCase("no"))
			{
				System.out.println("Goodbye!");
				System.exit(0);
			}
			else
			{
				System.out.println("INVALID. Ending the game.");
				System.exit(0);
			}
		}

	}

}
