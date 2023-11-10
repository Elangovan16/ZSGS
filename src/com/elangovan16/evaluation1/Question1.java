package com.elangovan16.evaluation1;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = sc.nextInt();
		int maxCount = (n * (n + 1)) / 2;
		System.out.println(maxCount);

		int[][] ans = new int[n][n];
		int i = 0;
		int j = 0;
		int count = 1;
		int diff = 0;
		boolean down = true;
		boolean up = false;
		boolean left = false;
		while (maxCount > 0) {
			if (down) {
				ans[i][j] = count++;
				i++;
				maxCount--;
				if (i == n - 1 - diff) {
					diff++;
					down = false;
					up = true;
				}
			}
			if (up) {
				ans[i][j] = count++;
				i--;
				j++;
				maxCount--;
				if (j == n - diff) {
					diff++;
					up = false;
					left = true;
				}
			}
			if (left) {
				ans[i][j] = count++;
				maxCount--;
				j--;
				if (j == n - diff) {
					diff++;
					left = false;
					down = true;
				}
			}
		}
		printArr(ans);
	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
