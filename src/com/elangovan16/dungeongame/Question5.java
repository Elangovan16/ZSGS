package com.elangovan16.dungeongame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question5 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Question5 obj = new Question5();

		System.out.print("Dimension of the dungeon (Row x Column) : ");
		char[][] dungeon = new char[obj.sc.nextInt()][obj.sc.nextInt()];

		System.out.print("Position of adventurer : ");
		int[] adven = new int[2];
		adven[0] = obj.sc.nextInt() - 1;
		adven[1] = obj.sc.nextInt() - 1;

		System.out.print("Position of Gold : ");
		int[] gold = new int[2];
		gold[0] = obj.sc.nextInt() - 1;
		gold[1] = obj.sc.nextInt() - 1;

		System.out.print("Enter number of pites : ");
		int n = obj.sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print("Position of pit " + i + " : ");
			dungeon[obj.sc.nextInt() - 1][obj.sc.nextInt() - 1] = 'P';
		}

		dungeon[gold[0]][gold[1]] = 'G';
		dungeon[adven[0]][adven[1]] = 'A';

		int steps = obj.findSteps(dungeon, gold, adven);
		if (steps != -1) {
			obj.findPath(adven, gold, dungeon);
			System.out.println("Minimum number of steps : " + steps);
		} else {
			System.out.println("No possible solution");
		}
	}

	private void findPath(int[] adven, int[] gold, char[][] dungeon) {
		StringBuilder sb = new StringBuilder();
		sb.append("Path: ");

		while (adven[1] != gold[1]) {
			sb.append("(" + (adven[0] + 1) + "," + (adven[1] + 1) + ") --> ");
			if (adven[1] > gold[1] && dungeon[adven[0]][adven[1]] != 'P') {
				adven[1] = adven[1] - 1;
			} else if (adven[1] < gold[1] && dungeon[adven[0]][adven[1]] != 'P') {
				adven[1] = adven[1] + 1;
			}
			else {
				break;
			}
		}
		while (adven[0] != gold[0]) {
			sb.append("(" + (adven[0] + 1) + "," + (adven[1] + 1) + ") --> ");
			if (adven[0] > gold[0] && dungeon[adven[0]][adven[1]] != 'P') {
				adven[0] = adven[0] - 1;
			} else if (adven[0] < gold[0] && dungeon[adven[0]][adven[1]] != 'P') {
				adven[0] = adven[0] + 1;
			}
			else {
				break;
			}
		}
		sb.append("(" + (adven[0] + 1) + "," + (adven[1] + 1) + ")");
		System.out.println(sb.toString());
	}

	private int findSteps(char[][] dungeon, int[] endPos, int[] curPos) {
		int rows = dungeon.length;
		int cols = dungeon[0].length;

		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		boolean[][] visited = new boolean[rows][cols];
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { curPos[0], curPos[1], 0 });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curRow = cur[0];
			int curCol = cur[1];
			int curSteps = cur[2];

			if (curRow == endPos[0] && curCol == endPos[1]) {
				return curSteps;
			}

			for (int[] dir : directions) {
				int newRow = curRow + dir[0];
				int newCol = curCol + dir[1];

				if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]
						&& dungeon[newRow][newCol] != 'P') {
					queue.offer(new int[] { newRow, newCol, curSteps + 1 });
					visited[newRow][newCol] = true;
				}
			}
		}

		return -1;
	}
}
