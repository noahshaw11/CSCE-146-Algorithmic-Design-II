/*
 * Created by Noah Shaw
 */
import java.util.Random;
public final class Lab01 {
	
	public static final int BOARD_SIZE = 10;
	enum Space {Empty, Mine};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create an empty board
		System.out.println("CREATING EMPTY BOARD:");
		Space[][] board = new Space[BOARD_SIZE][BOARD_SIZE];
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				board[i][j] = Space.Empty;
				System.out.print("_ ");
			}
			System.out.println();
		}
		//Place the mines
		System.out.println("PLACING MINES:");
		Random rand = new Random();
		for(int i = 0; i < 10; i++)
		{
			int mX = rand.nextInt(BOARD_SIZE);
			int mY = rand.nextInt(BOARD_SIZE);
			if(board[mX][mY] != null && board[mX][mY] == Space.Mine)
			{
				while(board[mX][mY] == Space.Mine)
				{
					mX = rand.nextInt(BOARD_SIZE);
					mY = rand.nextInt(BOARD_SIZE);
				}
			}
			board[mX][mY] = Space.Mine;
		}
		//Draw the board with mines placed
		boolean done = false;
		while(!done)
		{
			//Draw the board
			for(int i = 0; i < board.length; i++)
			{
				for(int j = 0; j < board[i].length; j++)
				{
					switch(board[i][j])
					{
					case Empty:
						System.out.print("_ ");
						break;
					case Mine:
						System.out.print("* ");
						break;
					default:
						System.out.print("? ");
						break;
					}
				}
				System.out.println();
			}
			done = true;
		}
		//Perform the mine count
		System.out.println("PERFORMING MINE COUNT:");
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				int count = 0;
				if(i != 0 && j != 0 && board[i - 1][j - 1] == Space.Mine)
					count++;
				if(i != 0 && board[i - 1][j] == Space.Mine)
					count++;
				if(i != 0 && j != 9 && board[i - 1][j + 1] == Space.Mine)
					count++;
				if(j != 0 && board[i][j - 1] == Space.Mine)
					count++;
				if(j != 9 && board[i][j + 1] == Space.Mine)
					count++;
				if(i != 9 && j != 0 && board[i + 1][j - 1] == Space.Mine)
					count++;
				if(i != 9 && board[i + 1][j] == Space.Mine)
					count++;
				if(i != 9 && j != 9 && board[i + 1][j + 1] == Space.Mine)
					count++;
				if(board[i][j] == Space.Mine)
					System.out.print("* ");
				else
					System.out.print(count + " ");
			}
			System.out.println();
		}

	}

}
