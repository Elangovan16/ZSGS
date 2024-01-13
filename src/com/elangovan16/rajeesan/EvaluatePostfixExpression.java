package com.elangovan16.rajeesan;

import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfixExpression {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Expression : ");
		String exp = sc.nextLine();
		int res = evaluatePostfixExpression(exp);
		System.out.println("Result is : " + res);
	}

	public static int evaluatePostfixExpression(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				stack.push(c - '0');
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				int res = evaluate(c, operand1, operand2);
				stack.push(res);

			}
		}
		return stack.pop();
	}

	static int evaluate(char c, int operand1, int operand2) {
		switch (c) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		}
		return 0;
	}
}
