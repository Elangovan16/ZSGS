package com.elangovan16.leetcode;

public class Numberof1Bits {//191. Number of 1 Bits
	public static void main(String[] args) {
		System.out.println(hammingWeight(8));
	}
    public static int hammingWeight(int n) {
    int ones=0;
        while(n!=0) {
    		ones = ones + (n & 1);
    		n = n>>>1;
    	}
    return ones;
    }
}
