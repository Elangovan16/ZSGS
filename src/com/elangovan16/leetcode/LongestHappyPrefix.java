package com.elangovan16.leetcode;

public class LongestHappyPrefix {// 1392 .Longest Happy Prefix
	public static void main(String[] args) {
		longestPrefix("ababab");
	}

	public static String longestPrefix(String s) {
		for (int i = 1; i < s.length(); i++) {
			String suf = s.substring(i);
			String pre = s.substring(0, s.length() - i);
			if (suf.equals(pre)) {
				return suf;
			}
		}
		return "";
	}
}