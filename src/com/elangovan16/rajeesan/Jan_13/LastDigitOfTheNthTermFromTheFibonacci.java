package com.elangovan16.rajeesan.Jan_13;

import java.util.Scanner;

/*
* It is time for problem solving. Solve the below problem in optimised way within 30 mins. 
Given a positive integer N, find the last digit of the Nth term from the Fibonacci series.
*/
public class LastDigitOfTheNthTermFromTheFibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = sc.nextInt();

		int res = findNthFibonacci(n);
		System.out.println(n + " th Fibonacci is : " + res);
		System.out.println("It's last digit is : " + res % 10);
	}

	private static int findNthFibonacci(int n) {
		int[] fib = new int[n + 1];
		if (n >= 0) {
			fib[0] = 0;
		}
		if (n >= 1) {
			fib[1] = 1;
		}
		if (n >= 2) {
			for (int i = 2; i <= n; i++) {
				fib[i] = fib[i - 1] + fib[i - 2];
			}
		}
		return fib[n];
	}

}
