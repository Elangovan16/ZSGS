package com.elangovan16.rajeesan;

import java.util.Arrays;
import java.util.Scanner;

/*
	You are given a string that represent an expression of digits and operands. E.g.
	1+2*3, 1-2+4. You need to evaluate the string or the expression. NO BODMAS is
	followed. If the expression is of incorrect syntax return -1.
	Test cases:
		a) 1+2*3 will be evaluated to 9.
		b) 4-2+6*3 will be evaluated to 24.
		c) 1++2 will be evaluated to -1(INVALID).
			Also, in the string spaces can occur. For that case we need to ignore the spaces. Like :-
			1*2 -1 is equals to 1.
*/
public class ValidExpression {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Expression : ");
		String expression = sc.nextLine();
		System.out.println(validExpression(expression));
	}

	private static int validExpression(String expression) {
		int res = -1;
		String[] ex = expression.split("");
		String[] num = expression.split("[+-/*]");
		System.out.println(Arrays.deepToString(ex));
		System.out.println(Arrays.deepToString(num));
		String expressions = "+-/*";
		boolean flag = true;
		int index = 0;
		for (int i = 0; i < ex.length; i++) {
			if (expressions.contains(ex[i]) && i >= 1 && i < ex.length - 1) {
				if (ex[i - 1].matches("[0-9]") && ex[i + 1].matches("[0-9]")) {
					if (flag) {
						res = find(Integer.parseInt(num[index]), Integer.parseInt(num[index + 1]), ex[i]);
						index += 2;
						flag = false;
					} else {
						res = find(res, Integer.parseInt(num[index]), ex[i]);
						index += 1;
					}
				} else {
					return -1;
				}
			}
		}
		return res;
	}

	private static int find(int a, int b, String c) {

		switch (c) {
		case "+" -> {
			System.out.println(a + "+" + b + "=" + (a + b));
			return a + b;
		}
		case "-" -> {
			System.out.println(a + "-" + b + "=" + (a - b));
			return a - b;
		}
		case "*" -> {
			System.out.println(a + "*" + b + "=" + (a * b));
			return a * b;
		}
		case "/" -> {
			if (b == 0) {
				System.out.println("Number Can't / by 0");
				System.exit(0);
			}
			System.out.println(a + "/" + b + "=" + (a / b));
			return a / b;
		}
		}
		return 0;
	}
}
