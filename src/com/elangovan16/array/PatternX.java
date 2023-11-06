package com.elangovan16.array;

import java.util.Scanner;

public class PatternX {
	private static void xPattern(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (i == j || i + j == len - 1) {
					System.out.print(str.charAt(j));
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the Word");
		String word = sc.nextLine();

		if (word.length() % 2 != 0) {
			xPattern(word);
		} else {
			System.out.println("0");
		}
	}
}
