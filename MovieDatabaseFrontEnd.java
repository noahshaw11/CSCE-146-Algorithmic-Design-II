/*
 * Written by Noah Shaw
 */
import java.util.Scanner;
public class MovieDatabaseFrontEnd {
	
	public static MovieDatabase movieDatabase;
	public static Scanner keyboard;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		movieDatabase = new MovieDatabase();
		//Greet
		System.out.println("Welcome to the Movie Database!");
		boolean done = false;
		while(done != true)
		{
			System.out.println("\nEnter 1 to add a movie."
					+ "\nEnter 2 to remove a movie by its title."
					+ "\nEnter 3 to search for a title."
					+ "\nEnter 4 to search for movies by a director."
					+ "\nEnter 5 to search for movies by a given year."
					+ "\nEnter 6 to search for movies of a certain rating."
					+ "\nEnter 7 to print out all movies."
					+ "\nEnter 8 to print to a database file."
					+ "\nEnter 9 to load a database file."
					+ "\nEnter 0 to quit.");
			//Capture user input
			keyboard = new Scanner(System.in);
			int input = keyboard.nextInt();
			//Determine action based on input
			switch(input)
			{
			case 1:
				System.out.println("Enter the name, year, rating, director, and gross.");
				keyboard.nextLine();
				String name = keyboard.nextLine();
				int year = keyboard.nextInt();
				int rating = keyboard.nextInt();
				keyboard.nextLine();
				String director = keyboard.nextLine();
				int gross = keyboard.nextInt();
				movieDatabase.addMovie(new Movie(name, year, rating, director, gross));
				break;
			case 2:
				System.out.println("Enter the title of the movie you wish to remove.");
				keyboard.nextLine();
				movieDatabase.removeMovie(keyboard.nextLine());
				break;
			case 3:
				System.out.println("Enter the title of the movie you are looking for.");
				keyboard.nextLine();
				movieDatabase.search("title", keyboard.nextLine());
				break;
			case 4:
				System.out.println("Enter the director of the movie(s) you are looking for.");
				keyboard.nextLine();
				movieDatabase.search("director", keyboard.nextLine());
				break;
			case 5:
				System.out.println("Enter the year of the movie(s) you are looking for.");
				keyboard.nextLine();
				movieDatabase.search("year", keyboard.nextInt());
				break;
			case 6:
				System.out.println("Enter the rating of the movie(s) you are looking for.");
				keyboard.nextLine();
				movieDatabase.search("rating", keyboard.nextInt());
				break;
			case 7:
				System.out.println("\nPrinting:");
				movieDatabase.print();
				break;
			case 8:
				System.out.println("Enter the title of the database file you want to print to.");
				keyboard.nextLine();
				movieDatabase.writeToFile(keyboard.nextLine());
				break;
			case 9:
				System.out.println("Enter the title of the database file you want to load.");
				keyboard.nextLine();
				movieDatabase.readFromFile(keyboard.nextLine());
				break;
			case 0:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("ERROR: Invalid");
				break;
			}
		}

	}

}
