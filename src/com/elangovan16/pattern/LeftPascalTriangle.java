package com.elangovan16.pattern;

import java.util.Scanner;

public class LeftPascalTriangle {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Number : ");
			int n = Integer.parseInt(sc.nextLine());
			printPattern(n);
		}
	}

	private static void printPattern(int n) {
		for (int i = 1; i <= 2 * n - 1; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == n || i + j == n + 1 || i - j == n - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
