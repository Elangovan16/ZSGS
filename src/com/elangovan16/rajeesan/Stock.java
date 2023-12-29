package com.elangovan16.rajeesan;

import java.util.Scanner;

public class Stock {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of element : ");
		int n = sc.nextInt();
		int[] stock = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter the " + i + " element :");
			stock[i] = sc.nextInt();
		}
		int profit = 0;
		int min = stock[0];
		for (int i = 1; i < n; i++) {
			int curStock = stock[i];
			int curProfit = curStock - min;
			if (curStock - min > profit) {
				profit = curStock - min;
			}
			if (curProfit < min) {
				min = curProfit;
			}
		}
		System.out.println("Max Profit is : " + profit);
		sc.close();
	}
}
