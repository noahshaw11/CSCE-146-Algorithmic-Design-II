/*
 * Created by Noah Shaw
 */
import java.util.Scanner; //Java package
import java.util.Random; //Creates a random number generator
public class MarcoPolo {

	public static final int BOARD_SIZE = 10;
	public static final int COLD_DIST = (BOARD_SIZE*BOARD_SIZE)/2;
	public static final int WARM_DIST = (BOARD_SIZE*BOARD_SIZE)/4;
	enum Space {Empty, Player, Walked_Path, Goal}; //Enumerations or named constants
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in); //User input
		//Player's position
		int pX = 0;
		int pY = 0;
		//Goal's position
		Random r = new Random(); //RNG
		int gX = r.nextInt(BOARD_SIZE);
		int gY = r.nextInt(BOARD_SIZE);
		Space[][] board = new Space[BOARD_SIZE][BOARD_SIZE];
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j<board[i].length; j++)
				board[i][j] = Space.Empty;
		board[pX][pY] = Space.Player;
		board[gX][gY] = Space.Goal;
		//Game loop
		boolean gameOver = false;
		while(!gameOver)
		{
			//Draw the board
			for(int i = 0; i < board.length; i++)
			{
				for(int j = 0; j < board[i].length; j++)
				{
					switch(board[i][j])
					{
					case Empty:
						System.out.print("_");
						break;
					case Player:
						System.out.print("X");
						break;
					case Walked_Path:
						System.out.print("#");
						break;
					case Goal:
						System.out.print("_");
						break;
						default:
							System.out.print("?");
					}
				}
				System.out.println();
			}
			int distance = (pX-gX)*(pX-gX)+(pY-gY)*(pY-gY);
		}

	}

}