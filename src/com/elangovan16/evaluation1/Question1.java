package com.elangovan16.evaluation1;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = sc.nextInt();
		int[][] mat = getTriangleSpiral(n);
		printMatrix(mat);
	}

	private static int[][] getTriangleSpiral(int n) {
		int[][] mat = new int[n][n];
		int count = 1;
		int left = 0, right = n - 1;
		int top = 0, bottom = n - 1;
		while (left <= right && top <= bottom) {
			
			for (int i = left; i <= right; i++) {
				mat[top][i] = count++;
			}
			top++;
			left++;
			for (int i = top; i <= bottom; i++) {
				mat[i][right] = count++;
			}
			right--;
			bottom--;
			for (int i = bottom; i >= top; i--) {
				mat[i][i-top+left] = count++;
			}
			left++;
			bottom--;

		}
		return mat;
	}

	private static void printMatrix(int[][] mat) {
		for (int[] i : mat) {
			for (int j : i) {
				if (j == 0)
					System.out.printf("   ");
				else
					System.out.printf("%2d ", j);
			}
			System.out.println();
		}
	}
}
