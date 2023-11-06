package com.elangovan16.pattern;

import java.util.Scanner;

public class HollowInvertedRightTriangle {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Number : ");
			int n = Integer.parseInt(sc.nextLine());
			printPattern(n);
		}
	}

	private static void printPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i + j == n + 1 || i == 1 || j == 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
