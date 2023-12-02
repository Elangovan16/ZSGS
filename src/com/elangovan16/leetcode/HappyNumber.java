package com.elangovan16.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static void main(String[] args) {
		System.out.println(isHappy(9));
	}
    public static boolean isHappy(int n) {
        Set<Integer> seen=new HashSet<>();
        while(n!=1){
            seen.add(n);
            if(n<9){
                n=n*n;
            }
            else{
                n=digitSquareSum(n);
            }
            if(seen.contains(n)){
                return false;
            }
        }
        return true;
    }
    public static int digitSquareSum(int n) {
    int sum = 0, tmp;
    while (n>0) {
        tmp = n % 10;
        sum += tmp * tmp;
        n /= 10;
    }
    return sum;
}
}
