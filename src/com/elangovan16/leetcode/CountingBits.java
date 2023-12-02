package com.elangovan16.leetcode;

import java.util.Scanner;
public class CountingBits {//338. Counting Bits
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] ans=countBits(n);
	}
    public static int[] countBits(int n) {
        int[] ans=new int[n+1];
        ans[0]=0;
        for(int i=1;i<=n;i++){
            int temp=i;
            int count=0;
            while(temp!=0){
                temp=temp & (temp-1);
                count++;
            }
            ans[i]=count;
        }
        return ans;
    }
    public static void print(int[] arr) {
    	for(int  a:arr) {
    		System.out.println(a+" ");
    	}
    }
}