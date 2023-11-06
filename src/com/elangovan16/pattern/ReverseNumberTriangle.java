package com.elangovan16.pattern;

import java.util.Scanner;

public class ReverseNumberTriangle {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Number : ");
			int n = Integer.parseInt(sc.nextLine());
			printPyramid(n);
		}
	}

	private static void printPyramid(int n) {
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
