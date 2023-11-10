package com.elangovan16.evaluation1;

import java.util.Scanner;

public class Question2 { // jumbled number
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		String num = sc.nextLine();
		isJumbledNumber(num);
	}

	public static void isJumbledNumber(String num) {
		int num1;
		int num2;
		boolean flag;
		for (int i = 0; i < num.length() - 1; i++) {
			num1 = num.charAt(i) - '0';
			num2 = num.charAt(i + 1) - '0';
			flag = true;
			if (num1 == num2 - 1 || num1 == num2 + 1) {
				flag = false;
			}
			if (flag) {
				System.out.println(num + " is not a jumbled number");
				return;
			}
		}
		System.out.println(num + " is a jumbled number");
	}
}
