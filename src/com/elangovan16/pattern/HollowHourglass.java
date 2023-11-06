package com.elangovan16.pattern;

import java.util.Scanner;

public class HollowHourglass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = Integer.parseInt(sc.nextLine());
		printPattern(n);
	}

	private static void printPattern(int n) {
		for (int i = 1; i <= 2 * n - 1; i++) {
			for (int j = 1; j <= 2 * n - 1; j++) {
				if ((j % 2 == 1 && i == 1) || (j % 2 == 1 && i == 2 * n - 1) || i == j || i + j == 2 * n)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
