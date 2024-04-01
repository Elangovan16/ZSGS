package com.elangovan16.leetcode;

import java.util.Arrays;

public class FindPolygonWiththeLargestPerimeter {// 2971. Find Polygon With the Largest Perimeter
	public static void main(String[] args) {
		int[] arr = { 1, 12, 1, 2, 5, 50, 3 };
		long ans = largestPerimeter(arr);
		System.out.println("Output : " + ans);
	}

	 public static long largestPerimeter(int[] nums) {
	        long sum = 0;
	        Arrays.sort(nums);
	        for (int num : nums) {
	            sum += num;
	        }
	        int n = nums.length;
	        for (int i = n - 1; i >= 2; i--) {
	            sum -= nums[i];
	            if (sum > nums[i]) {
	                return sum + nums[i];
	            }
	        }
	        return -1;
	    }
}
