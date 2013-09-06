/*
Apparently this is a Microsoft interview question. Relatively simple. Just need to remember that the row
is the first 2d array parameter and the second is the column. This can be viewed because:

array = [] [] [] [] [] elements where each element can point to the values within
		1  2  3  4  5
		1  2  3  4  5  
		1  2  3  4  5
		1  2  3  4  5
		
as a normal matrix this would be as

1 1 1 1
2 2 2 2
3 3 3 3
4 4 4 4
5 5 5 5

The idea was to keep the loop as a single dual for instead of it broken out. This will work for n * m matrix as well
index controls whether to add it to the negative (reversed) column value or to null it out if 
the loop is an odd number row where the you read left to right.
*/
import java.util.Random;
public class spiral {
	public static Random gen = new Random();
	public static void main(String[] args){
		int row = gen.nextInt(10);
		int[][] matrix = new int[row][row];
		fillMatrix(matrix);
		System.out.println();
		spiralMatrix(matrix);
	}
	public static void spiralMatrix(int[][] matrix){
		int reverse = 1;
		int index = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][(j*reverse) + (index*(matrix[i].length-1))] + " ");
			reverse *= -1;
			index = (index == 0) ? 1 : 0;
			System.out.println();
		}
	}
	public static void fillMatrix(int[][] matrix)
	{
		for(int i =0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				matrix[i][j] = gen.nextInt(50);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
