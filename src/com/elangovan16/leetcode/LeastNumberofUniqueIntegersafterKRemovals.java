package com.elangovan16.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastNumberofUniqueIntegersafterKRemovals {// 1481. Least Number of Unique Integers after K Removals

	public static void main(String[] args) {
		int[] arr = { 5, 5, 4 };
		int k = 1;
		int res = findLeastNumOfUniqueInts(arr, k);
		System.out.println("OutPut : " + res);
	}

	public static int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> ele = new ArrayList<>(map.entrySet());

		ele.sort((a, b) -> a.getValue() - b.getValue());

		for (Map.Entry<Integer, Integer> entry : ele) {
			if (entry.getValue() <= k) {
				k -= entry.getValue();
				map.remove(entry.getKey());
			} else
				break;
		}
		return map.size();
	}

}
