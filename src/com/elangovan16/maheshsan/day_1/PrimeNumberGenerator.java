package com.elangovan16.maheshsan.day_1;

import java.util.Scanner;

public class PrimeNumberGenerator {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PrimeNumberGenerator obj = new PrimeNumberGenerator();
		System.out.println("Enter the Number : ");
		int num = sc.nextInt();
		obj.primeNumberGenerator(num);
	}

	private boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if ((i != 1 || i != n) && (n % i == 0))
				return false;
		}
		return true;
	}

	private void primeNumberGenerator(int num) {
		for (int i = 2; i <= num; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}
}
