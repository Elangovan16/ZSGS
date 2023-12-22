package com.elangovan16.problems.day_2;

import java.util.ArrayList;
import java.util.Scanner;

public class CombinationOfString {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		CombinationOfString obj = new CombinationOfString();
		ArrayList<String> res = new ArrayList<>();
		System.out.println("Enter String : ");
		String str = obj.sc.nextLine();
		obj.combination(str, "", res);
		System.out.println(res);
	}

	private void combination(String cur, String rem, ArrayList<String> res) {
		if (cur.isEmpty()) {
			res.add("{" + rem + "}");
			return;
		}
		combination(cur.substring(1), rem + cur.charAt(0), res);// pick
		combination(cur.substring(1), rem, res);  //not pick
	}

}
