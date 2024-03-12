// Exercise 6.6: Add 2 matrices of the same sizes

import java.util.*;

public class AddMatrices {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Number of rows of a matrix: ");
		int rows = Integer.parseInt(sc.nextLine());

		System.out.print("Number of columns of a matrix: ");
		int columns = Integer.parseInt(sc.nextLine());

		int[][] matrix1 = new int[rows][columns];
		int[][] matrix2 = new int[rows][columns];
		int[][] sumMatrix = new int[rows][columns];
		
		System.out.println("Enter the elements of matrix1 row by row:");
		for (int i = 0; i < rows; i++) {
			String[] row = sc.nextLine().trim().split("\\s+");
			for (int j = 0; j < columns; j++) {
				matrix1[i][j] = Integer.parseInt(row[j]);
			}
		}

		System.out.println("Enter the elements of matrix2 row by row:");
		for (int i = 0; i < rows; i++) {
			String[] row = sc.nextLine().trim().split("\\s+");
			for (int j = 0; j < columns; j++) {
				matrix2[i][j] = Integer.parseInt(row[j]);
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}

		// Printing
		System.out.println("The sum of the matrices is:");
		for (int i = 0; i < rows; i++) {
			System.out.println(Arrays.toString(sumMatrix[i]));
		}

		sc.close();
	}

}
