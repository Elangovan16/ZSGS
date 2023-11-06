package com.elangovan16.numberconversion;

import java.util.Scanner;

public class DecimalToBinary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the Decimal : ");
		long decimal = sc.nextLong();
		findBinary(decimal);
	}

	private static void findBinary(long decimal) {
		StringBuilder sb = new StringBuilder();
		while (decimal > 0) {
			sb.append(decimal % 2);
			decimal = decimal / 2;
		}
		System.out.println("\nYour decimal number binary value is : " + sb.reverse().toString());
	}
}
