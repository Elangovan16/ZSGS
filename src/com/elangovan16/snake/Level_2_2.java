package com.elangovan16.snake;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Level_2_2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int size = getBoardSize();
		int[][] board = getBoard(size);
		printBoard(board, size);
		List<Snake> snakeList = getSnakes();
		List<Ladder> ladderList = getLadders();
		Deque<Player> playerList = getPlayers();
		int ranCount = 0;
		boolean flag = true;
		while (flag) {
			Player curPlayer = playerList.poll();
			int curPos = curPlayer.getPosition();
			String name = curPlayer.getName();
			int random = randomNumber();
			Move move = checkPosition(curPos, random, snakeList, ladderList, size);
			curPlayer.setPosition(move.getNewPos());

			if (random == 6) {
				ranCount++;
			}

			if (move.getNewPos() == size * size) {
				System.out.println(
						name + " rolled a " + random + " and moved from " + curPos + " to " + move.getNewPos());
				System.out.println(name + " wins the game.");
				flag = false;
			} else if (move.getMove().equals("snake")) {
				System.out.println(
						name + " rolled a " + random + " and moved from " + curPos + " to " + (curPos + random));
				System.out.println("Opps snake! down from " + (curPos + random) + " to " + move.getNewPos());

			} else if (move.getMove().equals("ladder")) {
				System.out.println(
						name + " rolled a " + random + " and moved from " + curPos + " to " + (curPos + random));
				System.out.println("There is ladder, up from " + (curPos + random) + " to " + move.getNewPos());
			} else if (move.getMove().equals("normal")) {
				System.out.println(
						name + " rolled a " + random + " and moved from " + curPos + " to " + move.getNewPos());
			} else {
				System.out.println("If you get this " + random + " you don't reach the end " + name);
				System.out.println("Because your current position is " + move.getNewPos());
			}
			if (random == 6 && ranCount != 3) {
				playerList.addFirst(curPlayer);
				if (ranCount == 3) {
					ranCount = 0;
				}
			} else {
				playerList.add(curPlayer);
				ranCount = 0;
			}
			System.out.println();
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

	private static Deque<Player> getPlayers() {// no of players with their names
		Deque<Player> playerList = new LinkedList<>();
		System.out.print("Enter the Number of Player :");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println();
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter the " + i + " Player Name : ");
			String name = sc.nextLine();
			playerList.add(new Player(name, 0));
			System.out.println();
		}
		return playerList;
	}

	public static int randomNumber() {
		return (int) (Math.random() * 6) + 1;
	}

	private static Move checkPosition(int curPos, int random, List<Snake> snakeList, List<Ladder> ladderList,
			int size) {
		Move move = new Move();
		int newPos = curPos + random;
		if (newPos <= size * size) {

			for (Snake s : snakeList) {
				if (s.getHead() == newPos) {
					move.setMove("snake");
					move.setNewPos(s.getTail());
					return move;
				}
			}

			for (Ladder l : ladderList) {
				if (l.getBottom() == newPos) {
					move.setMove("ladder");
					move.setNewPos(l.getTop());
					return move;
				}
			}
			move.setMove("normal");
			move.setNewPos(newPos);
			return move;
		}
		move.setNewPos(curPos);
		move.setMove("out");
		return move;
	}

}
