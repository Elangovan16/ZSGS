package com.elangovan16.problems.day_2;

import java.util.Scanner;

public class MaximumGapInArray {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MaximumGapInArray obj = new MaximumGapInArray();
		int[] nums = obj.getNumbers();
		obj.sortNumber(nums, nums.length);
		obj.printMaximumGapInArray(nums);
	}

	private void printMaximumGapInArray(int[] nums) {
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] > max) {
				max = nums[i] - nums[i - 1];
			}
		}
		System.out.println("Maximum Gap in Array : " + max);
	}

	private void sortNumber(int[] nums, int len) {
		int i, value, index;
		for (i = 1; i < len; i++) {
			value = nums[i];
			index = i;
			while (index > 0 && nums[index - 1] > value) {
				nums[index] = nums[index - 1];
				index--;
			}
			nums[index] = value;
		}
	}

	private int[] getNumbers() {
		System.out.println("Enter the length of Array : ");
		int len = sc.nextInt();
		int[] nums = new int[len];
		for (int i = 0; i < len; i++) {
			System.out.print("Enter the " + i + " Element : ");
			nums[i] = sc.nextInt();
		}
		System.out.println();
		return nums;
	}
}
