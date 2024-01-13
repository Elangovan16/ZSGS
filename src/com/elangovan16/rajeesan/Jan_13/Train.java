package com.elangovan16.rajeesan.Jan_13;

import java.util.Arrays;
import java.util.Scanner;

class Time implements Comparable<Time> {
	private int arrival;
	private int departure;

	public int getArrival() {
		return arrival;
	}

	public int getDeparture() {
		return departure;
	}

	public Time(int arrival, int departure) {
		this.arrival = arrival;
		this.departure = departure;
	}

	@Override
	public int compareTo(Time o) {
		return this.arrival - o.arrival;
	}

	public String toString() {
		return "Time { " + arrival + ":" + departure + " }";
	}
}

public class Train {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Train obj = new Train();
		Time[] times = obj.getTimes();
		int minPlatforms = obj.getMinPlatforms(times);
		System.out.println(minPlatforms + " Platform is needed");
	}

	private int getMinPlatforms(Time[] times) {
		Arrays.sort(times);
		for (int i = 0; i < times.length; i++) {
			System.out.println(times[i]);
		}
		int res = 1, plat = 1;
		for (int i = 0; i < times.length; i++) {
			plat = 1;
			for (int j = i; j < times.length; j++) {
				if (i != j)
					if (times[i].getDeparture() >= times[j].getArrival())
						plat++;
			}
			res = Math.max(plat, res);
		}
		return res;
	}

	private Time[] getTimes() {
		System.out.println("Enter how many train to enter : ");
		int n = sc.nextInt();
		Time[] temp = new Time[n];
		System.out.println("If Time is (9:00) you enter 900");
		System.out.println("If Time is (23:59) you enter 2359");
		int arr, dep;
		for (int i = 0; i < n; i++) {
			System.out.print("Enter " + i + " train Arrival Time : ");
			arr = sc.nextInt();
			System.out.print("Enter " + i + " train Departure Time : ");
			dep = sc.nextInt();
			temp[i] = new Time(arr, dep);
		}
		return temp;
	}

}
