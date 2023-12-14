package com.elangovan16.problems.day_2;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>(List.of(4, 35, 6, 32, 43, 44, 43, 4, 4, 35, 6));
		List<Integer> res = new ArrayList<>();

		for (int n : numList) {
			if (!res.contains(n)) {
				res.add(n);
			}
		}

		System.out.println(res);
	}
}
