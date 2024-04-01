package com.elangovan16.leetcode;

public class FindFirstPalindromicStringintheArray { // 2108. Find First Palindromic String in the Array
	public static void main(String[] args) {

	}

	public static String firstPalindrome(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (isPalindrome(words[i])) {
				return words[i];
			}
		}
		return "";
	}

	private static boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true; 
    }
}
