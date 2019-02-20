/*
 * Created by Noah Shaw
 */
import java.util.Random;
public class Lab00 {

	public static final int MATRIX_SIZE = 4;
	public static final int MAX_ROLL = 10;
	public static final int RESULT_SIZE = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Construct first matrix and populate with random values
		int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
		System.out.println("Initial Matrix:");
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				Random rand = new Random();
				int num = rand.nextInt(MAX_ROLL);
				matrix[i][j] = num;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Result Matrix:");
		//Construct second matrix and populate with the average of each quadrant in the first matrix
		double[][] result = new double[RESULT_SIZE][RESULT_SIZE];
		int s = 0;
		for(int i = 0; i < RESULT_SIZE; i++)
		{
			int y = 0;
			for(int j = 0; j < RESULT_SIZE; j++)
			{
				result[i][j] = (double)matrix[s][y] + (double)matrix[s][y+1] + (double)matrix[s+1][y] + (double)matrix[s+1][y+1];
				result[i][j] = result[i][j]/4;
				y += 2;
				System.out.print(result[i][j] + " ");
			}
			s += 2;
			System.out.println();
		}

	}

}