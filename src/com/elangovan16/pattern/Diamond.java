package com.elangovan16.pattern;

import java.util.Scanner;

public class Diamond {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Number : ");
			int n = sc.nextInt();
			printPattern(n);
		}
	}

	private static void printPattern(int n) {
		for (int i = 1; i <= 2 * n - 1; i++) {
			for (int j = 1; j <= 2 * n - 1; j++) {
				if (j - i == n - 1 || i - j == n - 1 || i + j == n + 1 || i + j == 3 * n - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
