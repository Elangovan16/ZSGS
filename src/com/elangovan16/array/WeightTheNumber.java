package com.elangovan16.array;

import java.util.Arrays;
import java.util.Scanner;

public class WeightTheNumber {
	public static void main(String[] args) {
		int[][] numbers = getNumbers();
		selectionSort(numbers);
		printArray(numbers);
	}

	private static int[][] getNumbers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number count");
		int n = Integer.parseInt(sc.nextLine());
		int[][] arr = new int[n][2];
		System.out.println("Enter the Number using space(\" \")");
		for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(sc.nextLine());
			arr[i][1] = addWeigth(arr[i][0]);
		}
		return arr;
	}

	private static boolean isPerfectSquare(int num) {
		return (int) (Math.sqrt(num)) * (int) (Math.sqrt(num)) == num;
	}

	private static boolean isMulipleAndDivisible(int num) {
		return (num % 4 == 0 && num % 6 == 0);
	}

	private static boolean isEven(int num) {
		return (num % 2 == 0);
	}

	private static int addWeigth(int num) {
		int sum = 0;
		if (isPerfectSquare(num))
			sum += 5;
		if (isMulipleAndDivisible(num))
			sum += 4;
		if (isEven(num))
			sum += 3;
		return sum;
	}

	private static void printArray(int[][] arr) {
		for (int[] a : arr) {
			System.out.print(Arrays.toString(a));
		}
	}

	private static void selectionSort(int[][] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i][1] < arr[j][1]) {
					int[] temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
