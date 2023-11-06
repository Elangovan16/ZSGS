package com.elangovan16.pattern;

import java.util.Scanner;

public class HollowPyramid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = sc.nextInt();
		printPattern(n);
	}

	private static void printPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 2 * n - 1; j++) {
				if (i == n || i + j == n + 1 || j - i == n - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
