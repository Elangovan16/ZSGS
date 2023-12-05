package com.elangovan16.evaluation2;

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Question5 q5 = new Question5();
		System.out.println("Enter String : ");
		String str = sc.nextLine();// WELCOMETOZOHOSCHOOLFORGRADUATESTUDIES

		q5.findIndex(str);
	}

	private void findIndex(String str) {
		System.out.println("Enter the Column: ");
		int column = sc.nextInt();
		sc.nextLine();
		char[][] mat = getMatrix(str, column);
		printMatrix(mat);
		System.out.println("Enter the Search Word : ");
		String sub = sc.nextLine();
		getIndex(mat, sub);
	}

	private void getIndex(char[][] mat, String sub) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == sub.charAt(0)) {
					if (mat[0].length > j + sub.length() - 1 && findWordInMatrix(mat, i, j, sub, true)) {
						System.out.println("Start index : <" + i + "," + j + ">");
						System.out.println("End index : <" + i + "," + (j + sub.length() - 1) + ">");
					}
					if (mat.length > i + sub.length() - 1 && findWordInMatrix(mat, i, j, sub, false)) {
						System.out.println("Start index : < " + i + "," + j + ">");
						System.out.println("End index : <" + (i + sub.length() - 1) + "," + j + ">");
					}
				}
			}
		}
	}

	private boolean findWordInMatrix(char[][] mat, int row, int col, String sub, boolean flag) {
		int index = 0;
		if (flag) {
			for (int i = col; i < col + sub.length(); i++) {
				if (sub.charAt(index++) != mat[row][i]) {
					return false;
				}
			}
		} else {
			for (int i = row; i < row + sub.length(); i++) {
				if (sub.charAt(index++) != mat[i][col]) {
					return false;
				}
			}
		}

		return true;
	}

	private char[][] getMatrix(String str, int col) {
		int index = 0;
		int row = str.length() / col;
		if (str.length() % col != 0) {
			row += 1;
		}
		char[][] arr = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (index < str.length()) {
					arr[i][j] = str.charAt(index++);
				}
			}
		}
		return arr;
	}

	private void printMatrix(char[][] mat) {
		for (char[] c : mat) {
			System.out.println(Arrays.toString(c));
		}
	}

}
