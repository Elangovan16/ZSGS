package com.elangovan16.problems.day_1;

import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PascalTriangle obj = new PascalTriangle();
		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
		obj.getPascalTriangle(mat);
		obj.printPascalTriangle(mat);
	}

	private void getPascalTriangle(ArrayList<ArrayList<Integer>> mat) {
		System.out.println("Enter the N : ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					temp.add(1);
				} else {
					temp.add(mat.get(i - 1).get(j - 1) + mat.get(i - 1).get(j));
				}
			}
			mat.add(temp);
		}
	}

	private void printPascalTriangle(ArrayList<ArrayList<Integer>> mat) {
		int len = mat.size();
		for (ArrayList<Integer> list : mat) {
			for (int i = 0; i < len; i++) {
				System.out.print("  ");
			}
			for (int num : list) {
				System.out.printf("%4d", num);
			}
			System.out.println();
			len--;
		}
	}
}
