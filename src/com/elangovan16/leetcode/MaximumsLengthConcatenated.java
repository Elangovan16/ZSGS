package com.elangovan16.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumsLengthConcatenated {// 1239. Maximum Length of a Concatenated String with Unique Characters
	public static void main(String[] args) {

		List<String> list = new ArrayList<>(List.of("un", "iq", "ue"));

		int res = maxLength(list);
		System.out.println("Result is : " + res);
	}

	public static int maxLength(List<String> arr) {
		return getMaxLength(arr, "", 0);
	}

	private static int getMaxLength(List<String> arr, String s, int index) {

		if (!isUnique(s)) {
			return 0;
		}
		int max = s.length();
		for (int i = index; i < arr.size(); i++) {
			max = Math.max(max, getMaxLength(arr, s + arr.get(i), i + 1));
//			s.delete(s.length() - arr.get(i).length(), s.length());
		}
		return max;
	}

	public static boolean isUnique(String s) {
		boolean[] seen = new boolean[26];
		for (char c : s.toCharArray()) {
			int i = c - 'a';
			if (seen[i]) {
				return false;
			}
			seen[i] = true;
		}
		return true;
	}
}
