package com.elangovan16.rajeesan;

import java.util.Scanner;

public class AddWithOutPlus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num1 and num2 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		int res = num1 - (-num2);

		System.out.println(num1 + " + " + num2 + " = " + res);
	}
}
