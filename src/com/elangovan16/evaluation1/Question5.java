package com.elangovan16.evaluation1;

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {
	public static void main(String[] args) {
		// XKDGTGA,HADF,DCBA
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of string to be entered : ");
		int n = sc.nextInt();
		sc.nextLine();
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the string " + (i + 1) + " : ");
			strs[i] = sc.nextLine();
		}
		sortLexicographically(strs, n);
		Arrays.sort(strs);
		printArr(strs, n);
	}

	public static void sortLexicographically(String[] strs, int n) {
		for (int i = 0; i < n; i++) {
			char[] c = strs[i].toCharArray();
			for (int j = 1; j <= c.length; j++) {
				for (int k = 0; k < c.length - j; k++) {
					if (c[k] < c[k + 1]) {
						char ch = c[k];
						c[k] = c[k + 1];
						c[k + 1] = ch;
					}
				}
			}
			strs[i] = new String(c);
		}
	}

	public static void printArr(String[] strs, int n) {
		int count = 1;
		for (int i = n - 1; i >= 0; i--) {
			System.out.println("String " + (count++) + " : " + strs[i]);
		}
	}
}
