package com.elangovan16.rajeesan;

import java.util.Scanner;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many string : ");
		int n = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[n];
		int min = 999;
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter " + i + " string : ");
			arr[i - 1] = sc.nextLine();
			if (arr[i - 1].length() < min) {
				min = arr[i - 1].length();
			}
		}
		String ans = longestCommonPrefix(arr, min);
		System.out.println("Longest Common Prefix is : " + ans);
	}

	public static String longestCommonPrefix(String[] arr, int min) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < min; i++) {
			char c = arr[0].charAt(i);
			for (int j = 1; j < arr.length; j++) {
				if (c != arr[j].charAt(i)) {
					return sb.toString();
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
