package com.elangovan16.rajeesan;

import java.util.Arrays;
import java.util.Scanner;

public class MoveAllZeros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of element : ");
		int n = sc.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter the " + i + " element :");
			num[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if (num[i] == 0) {
				for (int j = i; j < n; j++) {
					if (num[j] != 0) {
						num[i] = num[j];
						num[j] = 0;
						i = j;
						i--;
						break;
					}
				}
			}
		}
		System.out.println(Arrays.toString(num));
		sc.close();
	}
}
