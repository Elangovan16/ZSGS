package com.elangovan16.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {
	public static void main(String[] args) {
		int[] num= {4,6,5,9,3,7};
		int[] l= {0,0,2};
		int[] r= {2,3,5};
		List<Boolean> ans=checkArithmeticSubarrays(num,l,r);
		System.out.println(ans);
	}
	public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> ans=new ArrayList<>();
		for(int i=0;i<l.length;i++) {
			int[] arr=Arrays.copyOfRange(nums, l[i], r[i]+1);
			Arrays.sort(arr);
			System.out.println(Arrays.toString(arr));
			ans.add(isArithmeticSubarray(arr));
		}
		return ans;
	}
	public static Boolean  isArithmeticSubarray(int[] arr) {
		int min=arr[0]-arr[1];
		for(int i=2;i<arr.length-1;i++) {
			if(min!=arr[i]-arr[i+1]) {
				return false;
			}
		}
		return true;
	}
}
