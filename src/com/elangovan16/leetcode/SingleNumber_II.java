package com.elangovan16.leetcode;

import java.util.HashMap;

public class SingleNumber_II {
	public static void main(String[] args) {
		int[] arr= {0,1,0,1,0,1,99};
		System.out.println(singleNumber(arr));
	}
	public static int singleNumber(int[] nums) {
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(hm.containsKey(nums[i])) {
				hm.replace(nums[i], hm.get(nums[i])+1);
			}
			else {
				hm.put(nums[i], 1);
			}
		}
		int[] ans = {0};
		hm.forEach((key,value)->{
			if(value==1) {
				ans[0]=key;
			}
		});
        return ans[0];
    }
}
