package com.elangovan16.leetcode;

public class MinimumAmount {//2391. Minimum Amount of Time to Collect Garbage
	public static void main(String[] args) {
		//Input: garbage = ["G","P","GP","GG"], travel = [2,4,3]  Output: 21 metal, paper and glass
		MinimumAmount obj=new MinimumAmount();
		String[] garbage= {"G","P","GP","GG"};
		int[] travel= {2,4,3};
		System.out.println(obj.garbageCollection(garbage, travel));
	}
	public int garbageCollection(String[] garbage, int[] travel) {
		boolean g=false;
		boolean p=false;
		boolean m=false;
		int paper=0;
		int glass=0;
		int metal=0;
		for(int i=garbage.length-1;i>=0;i--) {
			
			for(char c:garbage[i].toCharArray()) {
				if(c=='P') {
					paper++;
					p=true;
				}
				else if(c=='G') {
					glass++;
					g=true;
				}
				else {
					metal++;
					m=true;
				}
					
			}
			if(i!=0&&g)
				glass+=travel[i-1];
			if(i!=0&&p)
				paper+=travel[i-1];
			if(i!=0&&m)
				metal+=travel[i-1];
		}
		return glass+paper+metal;
    }
}
