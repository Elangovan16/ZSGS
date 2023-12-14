package com.elangovan16.leetcode;

import java.util.Arrays;

public class ExecutionofAllSuffix {//2120. Execution of All Suffix Instructions Staying in a Grid

	public static void main(String[] args) {//n = 3, startPos = [0,1], s = "RRDDLU" res=[1,5,4,3,1,0]
		ExecutionofAllSuffix obj =new ExecutionofAllSuffix();
		int n=3;
		int[] startPos= {0,1};
		String s="RRDDLU";
		int[] ans=obj.executeInstructions(n,startPos,s);
		System.out.println(Arrays.toString(ans));
	}
	public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans=new int[s.length()];
        for(int i=0;i<s.length();i++){
            ans[i]=move(n,startPos[0],startPos[1],s.substring(i).toCharArray());
        }
        return ans;
    }
    public int move(int n,int row,int col,char[] s){
        int count=0;
    	for(int i=0;i<s.length;i++){
        	if(s[i]=='L'&&--col>=0) {
        		count++;
        	}else if(s[i]=='R'&&++col<=n-1) {
        		count++;
        	}else if(s[i]=='U'&&--row>=0) {
        		count++;
        	}
        	else if(s[i]=='D'&&++row<=n-1){
        		count++;
        	}
        	else {
        		break;
        	}
        }
        return count;
    }

}
