package com.elangovan16.leetcode;

public class Base7 {
	public static void main(String[] args) {
		System.out.println(convertToBase7(99));
	}
	public static String convertToBase7(int num) {
        int base=1;
        int ans=0;
        while(num!=0)
        {
            int rem=num%7;
            ans+=base*rem;
            base*=10;
            num/=7;
        }    
        return Integer.toString(ans);
    }
	
}
