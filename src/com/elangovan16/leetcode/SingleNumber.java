package com.elangovan16.leetcode;

public class SingleNumber {
	public static void main(String[] args) {
		int[] arr= {1,1,2,2,7,8,7};
		System.out.println(singleNumber(arr));
	}
	public static int singleNumber(int[] nums) {
        int ans=0;
        for(int i:nums){
            ans^=i;
        }
        return ans;
    }
}
