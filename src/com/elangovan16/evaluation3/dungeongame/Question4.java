package com.elangovan16.evaluation3.dungeongame;

import java.util.Scanner;

public class Question4 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Question4 obj = new Question4();

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

		System.out.print("Position of Trigger : ");
		int[] tri = new int[2];
		tri[0] = obj.sc.nextInt() - 1;
		tri[1] = obj.sc.nextInt() - 1;

		System.out.print("Position of Gold : ");
		int[] gold = new int[2];

		gold[0] = obj.sc.nextInt() - 1;
		gold[1] = obj.sc.nextInt() - 1;

		dungeon[gold[0]][gold[1]] = 'G';
		dungeon[mon[0]][mon[1]] = 'M';
		dungeon[adven[0]][adven[1]] = 'A';
		dungeon[tri[0]][tri[1]] = 'T';

		int advenSteps = obj.findSteps(gold, adven);
		int monSteps = obj.findSteps(gold, mon);
		int advenToTri = obj.findSteps(tri, adven);
		int triToGold = obj.findSteps(gold, tri);
		if (advenSteps > monSteps) {
			System.out.println("Minimum number of steps : " + (advenToTri + triToGold));
		} else {
			System.out.println("Minimum number of steps : " + advenSteps);

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
