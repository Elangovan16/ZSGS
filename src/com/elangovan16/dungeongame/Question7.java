package com.elangovan16.dungeongame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question7 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Question7 obj = new Question7();

		char[][] dungeon = obj.getDimension();
		int[] adven = obj.getAdventurePosition(dungeon);
		int[] mon = obj.getMonsterPosition(dungeon);
		int[] tri = obj.getTriggerPosition(dungeon);
		int[] gold = obj.getGoldPosition(dungeon);
		obj.addPitsInDungeon(dungeon);

		int advenSteps = obj.findSteps(dungeon, gold, adven);
		int monSteps = obj.findMinSteps(gold, mon);
		int advenToTri = obj.findSteps(dungeon, tri, adven);
		int triToGold = obj.findSteps(dungeon, gold, tri);
		if (advenSteps < monSteps) {
			System.out.println("Minimum number of steps : " + advenSteps);
			obj.findPath(adven, gold, dungeon);
		} else if (advenSteps != -1) {
			System.out.println("Minimum number of steps : " + (advenToTri + triToGold));
			obj.findPath(adven, tri, dungeon);
			obj.findPath(tri, gold, dungeon);
		} else {
			System.out.println("No possible solution");
		}
	}

	private char[][] getDimension() {
		System.out.print("Dimension of the dungeon (Row x Column) : ");
		char[][] dungeon = new char[sc.nextInt()][sc.nextInt()];
		return dungeon;
	}

	private int[] getAdventurePosition(char[][] dungeon) {
		System.out.print("Position of adventurer : ");
		int[] adven = new int[2];
		adven[0] = sc.nextInt() - 1;
		adven[1] = sc.nextInt() - 1;
		dungeon[adven[0]][adven[1]] = 'A';
		return adven;
	}

	private int[] getMonsterPosition(char[][] dungeon) {
		System.out.print("Position of Monster : ");
		int[] mon = new int[2];
		mon[0] = sc.nextInt() - 1;
		mon[1] = sc.nextInt() - 1;
		dungeon[mon[0]][mon[1]] = 'M';
		return mon;
	}

	private int[] getTriggerPosition(char[][] dungeon) {
		System.out.print("Position of trigger : ");
		int[] tri = new int[2];
		tri[0] = sc.nextInt() - 1;
		tri[1] = sc.nextInt() - 1;
		dungeon[tri[0]][tri[1]] = 'T';
		return tri;
	}

	private int[] getGoldPosition(char[][] dungeon) {
		System.out.print("Position of gold : ");
		int[] gold = new int[2];
		gold[0] = sc.nextInt() - 1;
		gold[1] = sc.nextInt() - 1;
		dungeon[gold[0]][gold[1]] = 'G';
		return gold;
	}

	private void addPitsInDungeon(char[][] dungeon) {
		System.out.print("Enter number of pites : ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print("Position of pit " + i + " : ");
			dungeon[sc.nextInt() - 1][sc.nextInt() - 1] = 'P';
		}
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

	private void findPath(int[] adven, int[] gold, char[][] dungeon) {
		StringBuilder sb = new StringBuilder();
		sb.append("Path: ");

		while (adven[1] != gold[1]) {
			sb.append("(" + (adven[0] + 1) + "," + (adven[1] + 1) + ") --> ");
			if (adven[1] > gold[1] && dungeon[adven[0]][adven[1]] != 'P') {
				adven[1] = adven[1] - 1;
			} else if (adven[1] < gold[1] && dungeon[adven[0]][adven[1]] != 'P') {
				adven[1] = adven[1] + 1;
			} else {
				break;
			}
		}
		while (adven[0] != gold[0]) {
			sb.append("(" + (adven[0] + 1) + "," + (adven[1] + 1) + ") --> ");
			if (adven[0] > gold[0] && dungeon[adven[0]][adven[1]] != 'P') {
				adven[0] = adven[0] - 1;
			} else if (adven[0] < gold[0] && dungeon[adven[0]][adven[1]] != 'P') {
				adven[0] = adven[0] + 1;
			} else {
				break;
			}
		}
		sb.append("(" + (adven[0] + 1) + "," + (adven[1] + 1) + ")");
		System.out.println(sb.toString());
	}

	private int findMinSteps(int[] gold, int[] pos) {
		int xdiff = Math.abs(gold[0] - pos[0]);
		int ydiff = Math.abs(gold[1] - pos[1]);
		return xdiff + ydiff;
	}
}
