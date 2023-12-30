package com.elangovan16.dungeongame;

import java.util.Scanner;

public class Question1 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Question1 obj = new Question1();

		System.out.print("Dimension of the dungeon (Row x Column) : ");
		char[][] dungeon = new char[obj.sc.nextInt()][obj.sc.nextInt()];

		System.out.print("Position of adventurer : ");
		int[] gold = new int[2];
		gold[0] = obj.sc.nextInt() - 1;
		gold[1] = obj.sc.nextInt() - 1;

		System.out.print("Position of Gold : ");
		int[] adven = new int[2];
		adven[0] = obj.sc.nextInt() - 1;
		adven[1] = obj.sc.nextInt() - 1;

		dungeon[gold[0]][gold[1]] = 'G';
		dungeon[adven[0]][adven[1]] = 'A';

		int steps = obj.findSteps(gold, adven);
		System.out.println("Minimum number of steps : " + steps);
	}

	private int findSteps(int[] gold, int[] adven) {
		int xdiff = Math.abs(gold[0] - adven[0]);
		int ydiff = Math.abs(gold[1] - adven[1]);
		return xdiff + ydiff;
	}

}
