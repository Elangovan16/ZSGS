package com.elangovan16.rajeesan.feb_8;

import java.util.Scanner;

//4. Write a Java program to find the longest common prefix among an array of strings.
//Input: ["flower","flow","flight"]
//
//Output: "fl"

public class Question_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many words do you want Enter : ");
		int n = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[n];
		int min = Integer.MAX_VALUE;
		System.out.println();
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter " + i + " word : ");
			arr[i - 1] = sc.nextLine();
			if (arr[i - 1].length() < min) {
				min = arr[i - 1].length();
			}
		}
		String ans = longestCommonPrefix(arr, min);
		System.out.println("\nOutput: " + ans);
		sc.close();
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
