package com.elangovan16.leetcode;

public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(-999));
	}
	public static int reverse(int x) {
        boolean flag=false;
        if(x<0){
            flag=true;
        }
        x=Math.abs(x);
        long ans=0;
        while(x>0){
            ans=ans*10+x%10;
            x=x/10;
        }
        if(ans<=Integer.MAX_VALUE&&ans>=Integer.MIN_VALUE){
            if(flag){
                return -1*(int)(ans);
            }
            else{
                return (int)(ans);
            }
        }
        else{
            return 0;
        }
    }
}
