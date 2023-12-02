package com.elangovan16.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverseII {
	public static void main(String[] args) {
		List<List<Integer>> li=new ArrayList<>(List.of(List.of(1,2,3),List.of(4,5,6),List.of(7,8,9)));
		int ans[]=findDiagonalOrder(li);
		System.out.println(Arrays.toString(ans));
	}
	public static int[] findDiagonalOrder(List<List<Integer>> nums) {
		Map<Integer,List<Integer>> map=new HashMap<>();
		int n=nums.size();
		int size=0;
		int maxSum=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<nums.get(i).size();j++) {
				int sum=i+j;
				map.putIfAbsent(sum,new ArrayList<>());
				map.get(sum).add(nums.get(i).get(j));
				size++;
				maxSum=Math.max(maxSum, sum);
			}
		}
		
		int[] ans=new int[size];
		int k=0;
		for(int i=0;i<=maxSum;i++) {
			List<Integer> cur=map.get(i);
			for(int j=cur.size()-1;j>=0;j--) {
				ans[k++]=cur.get(j);
			}
		}
		return ans;
    }
}
