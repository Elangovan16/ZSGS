package com.elangovan16.problems.day_1;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixRotation {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MatrixRotation obj = new MatrixRotation();
		int[][] matrix = obj.getMatrix();
		obj.rotateMatrix90(matrix,matrix.length);
		obj.printMatrix(matrix);
	}

	private void rotateMatrix90(int[][] mat, int len) {
		
		int start = 0;   				//invert
		int end = mat.length - 1;
		while (start < end) {
			int[] temp = mat[start];
			mat[start] = mat[end];
			mat[end] = temp;
			start++;
			end--;
		}

		for (int i = 0; i < len; i++) {  //transpose
			for (int j = i + 1; j < len; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
	}

	private int[][] getMatrix() {
		System.out.println("Enter the N : ");
		int n = sc.nextInt();
		sc.nextLine();
		int[][] mat = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("Enter " + i + " " + j + " element : ");
				mat[i][j] = sc.nextInt();
			}
			System.out.println();
		}
		return mat;
	}

	private void printMatrix(int[][] mat) {
		for (int[] i : mat) {
			System.out.println(Arrays.toString(i));
		}
	}
}
