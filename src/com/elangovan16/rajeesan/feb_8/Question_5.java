package com.elangovan16.rajeesan.feb_8;

import java.util.Scanner;

//5. Write a Java program to convert a string to its equivalent hexadecimal representation.
//Input: "hello world"
//
//Output: "68656C6C6F20776F726C64"

public class Question_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String str = sc.nextLine();
		String res = stringToHexadecimal(str);
		
		System.out.println("\nOutput : " + res);
		sc.close();
	}

	private static String stringToHexadecimal(String str) {
		StringBuilder sb = new StringBuilder();
		char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E','F'};
		for (char c : str.toCharArray()) {
			StringBuilder temp = new StringBuilder();
			char ch = c;
			while (ch > 0) {
				temp.append(hex[ch % 16]);
				ch /= 16;
			}
			sb.append(temp.reverse());
		}

		return sb.toString();
	}
}
