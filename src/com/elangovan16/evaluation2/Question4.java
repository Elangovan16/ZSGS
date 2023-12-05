package com.elangovan16.evaluation2;

import java.util.Scanner;

public class Question4 {
	public static void main(String[] args) {
		Question4 q4=new Question4();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String-1 : ");
		String s1=sc.nextLine().toLowerCase();
		System.out.println("Enter String-2 : ");
		String s2=sc.nextLine().toLowerCase();
		if(q4.isContains(s1,s2)) {
			System.out.println("true - "+s2+" can be formed");
		}
		else {
			System.out.println("false - "+s2+" cannot be formed");
		}
	}

	private boolean isContains(String s1, String s2) {
		boolean flag;
		boolean[] seen=new boolean[s1.length()];
		for(int i=0;i<s2.length();i++) {
			flag=true;
			for(int j=0;j<s1.length();j++) {
				if(s2.charAt(i)==s1.charAt(j)&&seen[j]==false) {
					flag=false;
					seen[j]=true;
					break;
				}
			}
			if(flag) {
				return false;
			}
		}
		return true;
	}
}
