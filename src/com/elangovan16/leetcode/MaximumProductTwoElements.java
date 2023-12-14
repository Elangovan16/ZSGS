package com.elangovan16.leetcode;

public class MaximumProductTwoElements {
	public static void main(String[] args) {
		MaximumProductTwoElements obj=new MaximumProductTwoElements();
		int[] nums= {3,4,5,2};
		int ans=obj.maxProduct(nums);
		System.out.println(ans);
	}
	public int maxProduct(int[] nums) {
		int max1=-1;
		int max2=-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>max1) {
				max2=max1;
				max1=nums[i];
			}
			else if(nums[i]>max2) {
				max2=nums[i];
			}
		}
		return (max1-1)*(max2-1);
	}
}
