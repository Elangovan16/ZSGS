package com.elangovan16.evaluation3.dungeongame;

import java.util.Scanner;

public class Question3 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Question3 obj = new Question3();

		System.out.print("Dimension of the dungeon (Row x Column) : ");
		char[][] dungeon = new char[obj.sc.nextInt()][obj.sc.nextInt()];

		System.out.print("Position of adventurer : ");
		int[] adven = new int[2];
		adven[0] = obj.sc.nextInt() - 1;
		adven[1] = obj.sc.nextInt() - 1;

		System.out.print("Position of Monster : ");
		int[] mon = new int[2];
		mon[0] = obj.sc.nextInt() - 1;
		mon[1] = obj.sc.nextInt() - 1;

		System.out.print("Position of Gold : ");
		int[] gold = new int[2];

		gold[0] = obj.sc.nextInt() - 1;
		gold[1] = obj.sc.nextInt() - 1;

		dungeon[gold[0]][gold[1]] = 'G';
		dungeon[mon[0]][mon[1]] = 'M';
		dungeon[adven[0]][adven[1]] = 'A';

		int advenSteps = obj.findSteps(gold, adven);
		int monSteps = obj.findSteps(gold, mon);

		if (advenSteps > monSteps) {
			System.out.println("No possible solution");
		} else {
			System.out.println("Minimum number of steps : " + advenSteps);
			obj.findPath(adven, gold);
		}

	}

	private void findPath(int[] adven, int[] gold) {
		StringBuilder sb = new StringBuilder();
		sb.append("Path: ");

		while (adven[1] != gold[1]) {
			sb.append("(" + (adven[0] + 1) + "," + (adven[1] + 1) + ") --> ");
			if (adven[1] > gold[1]) {
				adven[1] = adven[1] - 1;

			} else {
				adven[1] = adven[1] + 1;
			}
		}
		while (adven[0] != gold[0]) {
			sb.append("(" + (adven[0] + 1) + "," + (adven[1] + 1) + ") --> ");
			if (adven[0] > gold[0]) {
				adven[0] = adven[0] - 1;
			} else {
				adven[0] = adven[0] + 1;
			}
		}
		sb.append("(" + (adven[0] + 1) + "," + (adven[1] + 1) + ")");
		System.out.println(sb.toString());
	}

	private int findSteps(int[] gold, int[] pos) {
		int xdiff = Math.abs(gold[0] - pos[0]);
		int ydiff = Math.abs(gold[1] - pos[1]);
		return xdiff + ydiff;
	}

}
