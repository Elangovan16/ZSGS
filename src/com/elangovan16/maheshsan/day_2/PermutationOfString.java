package com.elangovan16.maheshsan.day_2;

import java.util.ArrayList;
import java.util.Scanner;

public class PermutationOfString {
	Scanner sc = new Scanner(System.in);
	static int c = 0;

	public static void main(String[] args) {
		PermutationOfString obj = new PermutationOfString();
		ArrayList<String> res = new ArrayList<>();
		System.out.println("Enter String : ");
		String str = obj.sc.nextLine();
		obj.permutation(str, "", res);
		System.out.println(res);
		System.out.println(c);
	}

	private void permutation(String cur, String res, ArrayList<String> result) {
		if (cur.isEmpty()) {
			c++;
			result.add(res);
			return;
		}

		for (int i = 0; i < cur.length(); i++) {
			char ch = cur.charAt(i);
			String newCur = cur.substring(0, i) + cur.substring(i + 1);
			permutation(newCur, res + ch, result);
		}
	}
}
