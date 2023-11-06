package com.elangovan16.pattern;

import java.util.Scanner;

public class PalindromicNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = Integer.parseInt(sc.nextLine());
		printPyramid(n);
	}

	private static void printPyramid(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print(k + " ");
			}
			for (int l = i - 1; l >= 1; l--) {
				System.out.print(l + " ");
			}
			System.out.println();
		}
	}
}
