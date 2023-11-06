package com.elangovan16.pattern;

import java.util.Scanner;

public class HollowDiamond {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Number : ");
			int n = Integer.parseInt(sc.nextLine());
			printPattern(n);
		}
	}

	private static void printPattern(int n) {
		for (int i = 1; i <= 2 * n; i++) {
			for (int j = 1; j <= 2 * n; j++) {
				if (i + j >= 2 && i + j <= n + 1 || j - i >= n && j - i <= 2 * n - 1)
					System.out.print("*");
				else if (i - j >= n && i - j <= 2 * n - 1 || i + j >= 3 * n + 1 && i + j <= 4 * n)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
