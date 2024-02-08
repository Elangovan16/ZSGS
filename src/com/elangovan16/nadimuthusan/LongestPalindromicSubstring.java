package com.elangovan16.nadimuthusan;

import java.util.Scanner;

public class LongestPalindromicSubstring {// LC : 5. Longest Palindromic Substring
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String str = sc.nextLine();

		String res = longestPalindrome(str);
		System.out.println();
	}

	public static String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		int max = 0;
		String longPalindrome = "";

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (j - i > max && isPalindrome(s.substring(i, j))) {
					max = j - i;
					longPalindrome = s.substring(i, j);
				}
			}
		}
		return longPalindrome;
	}

	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;

	}
}
