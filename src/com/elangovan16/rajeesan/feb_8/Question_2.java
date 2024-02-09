package com.elangovan16.rajeesan.feb_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//2. You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Find the longest chain which can be formed from a given set of pairs.
//
//Input : {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }
//Output - 3 
//Explanation 
//{{5, 24}, {27, 40}, {50, 90}}

public class Question_2 {
	public static void main(String[] args) {
//		int[][] pair = { { 5, 24 }, { 39, 60 }, { 15, 28 }, { 27, 40 }, { 50, 90 } };
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of pair : ");
		int n = sc.nextInt();
		int[][] pair = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			System.out.print("Enter the pair using ' '(space) like => 2 3 : ");
			pair[i][0] = sc.nextInt();
			pair[i][1] = sc.nextInt();
		}
		System.out.println();
		
		Comparator<int[]> com = (o1, o2) -> Integer.compare(o1[0], o2[0]);
		ArrayList<int[]> res = new ArrayList<>();
		Arrays.sort(pair, com);
		
		int[] cur = pair[0];
		res.add(cur);
		for (int i = 1; i < pair.length; i++) {
			if (pair[i][0] > cur[1]) {
				cur = pair[i];
				res.add(cur);
			}
		}
		
		System.out.println("res : ");
		for (int[] p : res) {
			System.out.println(Arrays.toString(p));
		}
	}
}
