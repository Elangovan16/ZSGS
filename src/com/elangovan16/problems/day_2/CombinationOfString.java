package com.elangovan16.problems.day_2;

import java.util.ArrayList;
import java.util.Scanner;

public class CombinationOfString {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		CombinationOfString obj = new CombinationOfString();
		ArrayList<String> combination = new ArrayList<>();
		System.out.println("Enter String : ");
		String str = obj.sc.nextLine();
		obj.nCr(str, "", combination);
		System.out.println(combination);
	}

	private void nCr(String cur, String rem, ArrayList<String> combination) {
		if (cur.isEmpty()) {
			combination.add("{" + rem + "}");
			return;
		}
		nCr(cur.substring(1), rem + cur.charAt(0), combination);// pick
		nCr(cur.substring(1), rem, combination);  //not pick
	}

}
