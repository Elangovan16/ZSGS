package com.elangovan16.evaluation1;

import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) {
		//(a+b)(a*b),(ab)(ab+),((a+b)
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Mathematical Expression : ");
		String ex = sc.nextLine();
		isValidMathematicalExpression(" "+ex+" ");
	}

	public static void isValidMathematicalExpression(String ex) {
		int para = 0;
		String expres = "+-*/";
		for (int i = 0; i < ex.length(); i++) {
			if (ex.charAt(i) == '(') {
				para++;
			} else if (ex.charAt(i) == ')') {
				if(para==0) {
					System.out.println("Invalid");
					return;
				}
				para--;
			} else if (expres.contains(ex.charAt(i)+"")){
				if ((!(ex.charAt(i-1)+"").matches("[A-Za-z0-9)]"))||(!(ex.charAt(i+1)+"").matches("[A-Za-z(0-9]"))) {
					System.out.println("Invalid");
					return;
				}
			}
		}
		if (para == 0) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}
}
