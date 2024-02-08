package com.elangovan16.nadimuthusan;

import java.util.Scanner;

public class TrappingRainWater {// LC : 42. Trapping Rain Water
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of Array : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.print("Enter number using space (' ') : ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int res = trap(arr);

		System.out.println("Output: " + res);
	}

	public static int trap(int[] height) {
		int len = height.length;
		int res = 0;
		int[] right = new int[len];
		int[] left = new int[len];
		int max = -1;

		for (int i = 0; i < len; i++) {
			if (height[i] > max) {
				right[i] = height[i];
				max = height[i];
			} else {
				right[i] = max;
			}
		}
		max = -1;
		for (int i = len - 1; i >= 0; i--) {
			if (height[i] > max) {
				left[i] = height[i];
				max = height[i];
			} else {
				left[i] = max;
			}
		}

		for (int i = 0; i < len; i++) {
			res += Math.min(left[i], right[i]) - height[i];
		}

		return res;
	}
}
