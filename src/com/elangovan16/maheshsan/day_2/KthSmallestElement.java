package com.elangovan16.maheshsan.day_2;

import java.util.Scanner;

public class KthSmallestElement {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		KthSmallestElement obj = new KthSmallestElement();
		int[] nums = obj.getNumbers();
		obj.sortNumber(nums, nums.length);
		obj.printKthSmallestElement(nums);
	}

	private void printKthSmallestElement(int[] nums) {
		System.out.println("Enter kth Smallest element : ");
		int n=sc.nextInt()-1;
		if(n>=0 && n<=nums.length) {
			System.out.println("kth Smallest element is : "+ nums[n]);
		}
		else {
			System.out.println("\nWrong input");
		}
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
