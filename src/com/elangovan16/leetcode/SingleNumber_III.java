package com.elangovan16.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber_III {
	public static void main(String[] args) {
		int[] arr= {1,2,1,3,2,5};
		System.out.println(singleNumber(arr));
	}

	public static int[] singleNumber(int[] nums) {
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(hm.containsKey(nums[i])) {
				hm.replace(nums[i], hm.get(nums[i])+1);
			}
			else {
				hm.put(nums[i], 1);
			}
		}
		int[] ans = new int[2];
        int i=0;
		for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            if(entry.getValue()==1){
                ans[i++]=entry.getKey();
            }
            if(i==2)
                break;
        }
        return ans;
}
}
