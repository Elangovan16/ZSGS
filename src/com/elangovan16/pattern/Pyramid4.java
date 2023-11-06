package com.elangovan16.pattern;

import java.util.Scanner;

public class Pyramid4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = sc.nextInt();
		printPyramid(n);
	}

	private static void printPyramid(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print(n - i + k + " ");
			}
			for (int l = 1; l <= i - 1; l++) {
				System.out.print(n - l + " ");
			}
			System.out.println();
		}
	}
}
