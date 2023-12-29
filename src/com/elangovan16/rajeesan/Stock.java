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
			int currentStock = stock[i];
			int currentProfit = currentStock - min;
			if (currentStock - min > profit) {
				profit = currentStock - min;
			}
			if (currentProfit < min) {
				min = currentProfit;
			}
		}
		System.out.println("Profit is : " + profit);
	}
}
