package com.elangovan16.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringInAnArray {// 2053. Kth Distinct String in an Array
	public static void main(String[] args) {
		String[] arr = { "a", "b", "a" };
		int k = 3;
		System.out.println(kthDistinct(arr, k));
	}

	public static String kthDistinct(String[] arr, int k) {
		int n = 1;
		boolean flag;
		Map<Integer, String> ma = new LinkedHashMap<>();
		for (int i = 0; i < arr.length; i++) {
			flag = true;
			for (int j = 0; j < arr.length; j++) {
				if (i != j && arr[i] == arr[j]) {
					flag = false;
				}
			}
			if (flag) {
				ma.put(n, arr[i]);
				n++;
			}
		}
		if (n < k) {
			return "| |";
		}
		return ma.get(k);
	}
}
