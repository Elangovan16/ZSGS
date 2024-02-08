package com.elangovan16.nadimuthusan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllGoodIndices {// LC : 2420. Find All Good Indices
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter lenght of Array : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.print("Enter number using space (' ') : ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print("Enter range : ");
		int k = sc.nextInt();
		List<Integer> ans = goodIndices(arr, k);

		System.out.println(ans);
	}

	public static List<Integer> goodIndices(int[] nums, int k) {
		List<Integer> ans = new ArrayList<>();
		for (int i = k; i <= nums.length - k; i++) {
			if (isGoodIndices(nums, i, k)) {
				ans.add(i);
			}
		}

		return ans;
	}

	private static boolean isGoodIndices(int[] nums, int index, int k) {
		for (int i = index - k; i < index; i++) {
			if (nums[i] < nums[i + 1]) {
				return false;
			}
		}

		for (int i = index + 1; i < k + index; i++) {
			if (nums[i] > nums[i + 1]) {
				return false;
			}
		}

		return true;
	}
}
