import java.util.Scanner;

public class TacoFrontEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TacoDB tacoDB = new TacoDB();
		Scanner keyboard = new Scanner(System.in);
		while(true)
		{
			printOps();
			int choice = keyboard.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter name, loc, price, rating");
				tacoDB.addTaco(new Taco(keyboard.nextLine(), keyboard.nextLine(), keyboard.nextDouble(), keyboard.nextInt()));
				break;
			}
		}
	}
	public static void printOps()
	{
		System.out.println("Enter 1 or Enter 2");
	}

}
