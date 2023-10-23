package zohoarray;

import java.util.Scanner;

public class ArrayMultiplication {
	private static void printArray(int[][] arr) {
		for (int x[] : arr) {
			for (int y : x) {
				System.out.print(y + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int[][] getMatrix() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Number of Row");
			int row = sc.nextInt();
			System.out.println("Enter Number of Column");
			int column = sc.nextInt();
			int[][] arr = new int[row][column];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			return arr;
		}
	}

	private static int[][] arrayMultiplication(int[][] a, int[][] b) {
		int arr[][] = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					arr[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[][] a = getMatrix();
		printArray(a);
		int[][] b = getMatrix();
		printArray(b);
		if (a[0].length == b.length) {
			int[][] c = arrayMultiplication(a, b);
			printArray(c);
		} else {
			System.out.println("We can not find this array Multiplication");
		}
	}
}
