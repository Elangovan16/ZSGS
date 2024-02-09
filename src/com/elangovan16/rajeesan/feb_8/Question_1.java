package com.elangovan16.rajeesan.feb_8;

import java.util.Scanner;

public class Question_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the date like(25-08-1998) : ");
		String date1 = sc.nextLine();
		System.out.print("Enter the date like(27-09-2020) : ");
		String date2 = sc.nextLine();
		System.out.println();

		int res = findDifference(date1, date2);

		System.out.println("Output : " + res);
		sc.close();
	}

	private static int findDifference(String date1, String date2) {
		int day1 = Integer.parseInt(date1.substring(0, 2));
		int month1 = Integer.parseInt(date1.substring(3, 5));
		int year1 = Integer.parseInt(date1.substring(6));
		int day2 = Integer.parseInt(date2.substring(0, 2));
		int month2 = Integer.parseInt(date2.substring(3, 5));
		int year2 = Integer.parseInt(date2.substring(6));

		int fromDays = year1 * 365 + (year1 / 4 + year1 / 400 - year1 / 100);
		int toDays = year2 * 365 + (year2 / 4 + year2 / 400 - year2 / 100) - 1;

		fromDays += getDays(month1, day1, isLeapYear(year1));
		toDays += getDays(month2, day2, isLeapYear(year2));

		return toDays - fromDays;
	}

	private static int getDays(int month, int day, boolean leapYear) {
		int[] mon = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int res = 0;
		if (leapYear) {
			res += 1;
		}
		for (int i = 1; i < month; i++) {
			res += mon[i];
		}
		return res + day;
	}

	private static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}
}
