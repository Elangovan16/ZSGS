package com.elangovan16.snake;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Level_2_1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int size = getBoardSize();
		int[][] board = getBoard(size);
		printBoard(board, size);
		List<Snake> snakeList = getSnakes();
		List<Ladder> ladderList = getLadders();
		int res = findMinStep(size, snakeList, ladderList);

		if (res == -1) {
			System.out.println("We can't reach the end");
		} else {
			System.out.println("Minimum Steps: " + res);
		}
	}

	private static int getBoardSize() {
		System.out.print("Enter Board Size : ");
		int size = sc.nextInt();
		System.out.println();
		return size;
	}

	private static int[][] getBoard(int size) {
		int[][] board = new int[size][size];

		for (int i = 1; i <= size; i++) {
			int start = (i - 1) * size + 1;
			int end = i * size;
			int index = 0;

			if (i % 2 != 0) {
				for (int j = start; j <= end; j++) {
					board[i - 1][index++] = j;
				}
			} else {
				for (int j = end; j >= start; j--) {
					board[i - 1][index++] = j;
				}
			}
		}
		return board;
	}

	private static void printBoard(int[][] board, int size) {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.printf("%4d", board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static List<Snake> getSnakes() { // no of snakes and it's head and tail
		List<Snake> snakeList = new ArrayList<>();
		System.out.print("Enter the Number of Snakes : ");
		int n = sc.nextInt();
		System.out.println();
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter " + i + " Snake Head : ");
			int head = sc.nextInt();
			System.out.print("Enter " + i + " Snake Tail : ");
			int tail = sc.nextInt();
			snakeList.add(new Snake(head, tail));
			System.out.println();
		}
		return snakeList;
	}

	private static List<Ladder> getLadders() { // no of ladders and it's bottom and top
		List<Ladder> ladderList = new ArrayList<>();
		System.out.print("Enter the Number of Ladder : ");
		int n = sc.nextInt();
		System.out.println();
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter " + i + " Ladder bottom : ");
			int bottom = sc.nextInt();
			System.out.print("Enter " + i + " Ladder top : ");
			int top = sc.nextInt();
			ladderList.add(new Ladder(bottom, top));
			System.out.println();
		}
		return ladderList;
	}

	private static int findMinStep(int size, List<Snake> snakeList, List<Ladder> ladderList) {
		int[] moves = new int[size * size + 1];
		boolean[] visited = new boolean[size * size + 1];

		for (int i = 1; i <= size * size; i++) {
			moves[i] = Integer.MAX_VALUE;
		}

		for (Snake snake : snakeList) {
			moves[snake.getHead()] = -1;
		}

		for (Ladder ladder : ladderList) {
			moves[ladder.getBottom()] = -1;
		}

		Queue<Integer> queue = new ArrayDeque<>(); // BFS
		queue.add(1); // Starting position
		visited[1] = true;
		moves[1] = 0;

		while (!queue.isEmpty()) {
			int currentPos = queue.poll();

			for (int i = 1; i <= 6; i++) {
				int nextPos = currentPos + i;

				if (nextPos <= size * size && !visited[nextPos]) {
					visited[nextPos] = true;

					// Check for snake or ladder
					for (Snake snake : snakeList) {
						if (nextPos == snake.getHead()) {
							nextPos = snake.getTail();
							break;
						}
					}

					for (Ladder ladder : ladderList) {
						if (nextPos == ladder.getBottom()) {
							nextPos = ladder.getTop();
							break;
						}
					}

					if (moves[nextPos] == Integer.MAX_VALUE) {
						queue.add(nextPos);
						moves[nextPos] = moves[currentPos] + 1;
					}
				}
			}
		}

		return moves[size * size] == Integer.MAX_VALUE ? -1 : moves[size * size];
	}
}