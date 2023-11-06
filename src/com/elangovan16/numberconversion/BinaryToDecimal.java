package com.elangovan16.numberconversion;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("\nEnter Binary Number : ");
			String binary=sc.nextLine();
			findDecimal(binary);
		}
	}

	private static void findDecimal(String binary) {
		if(binary.matches("[0-1]{1,32}")) {
			long decimal=0;
			int len=binary.length();
			for(int i=0;i<len;i++) {
				decimal+=(binary.charAt(len-(i+1))-'0')*Math.pow(2,i);
			}
			System.out.println("\nYour Binary Deciaml Number is : "+decimal);
		}
		else if(binary.length()>32){
			System.out.println("\nYour binary number is too long");
		}
		else {
			System.out.println("\nEnter valid number 0 and 1");
		}
		
	}
}