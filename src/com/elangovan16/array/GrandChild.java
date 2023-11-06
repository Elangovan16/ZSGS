package com.elangovan16.array;

import java.util.Scanner;

public class GrandChild {
	static Scanner sc = new Scanner(System.in);

	private static String[][] getFamilyMember() {

		System.out.println("\nEnter family count");
		int n = Integer.parseInt(sc.nextLine());
		String[][] arr = new String[n][2];
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter son name : ");
			arr[i][0] = sc.nextLine();
			System.out.print("Enter father name : ");
			arr[i][1] = sc.nextLine();
		}
		return arr;
	}

	private static int findSon(String[][] family, String grandFather) {
		int n = findCount(family, new String[] { grandFather });
		String father[] = new String[n];
		for (int i = 0; i < family.length; i++) {
			if (family[i][1].equals(grandFather)) {
				father[--n] = family[i][0];
			}
		}
		if (father.length == 0) {
			return 0;
		} else {
			return findCount(family, father);
		}
	}

	private static int findCount(String[][] family, String[] father) {
		int count = 0;
		for (int i = 0; i < father.length; i++) {
			for (int j = 0; j < family.length; j++) {
				if (family[j][1].equals(father[i])) {
					count++;
				}
			}
		}
		return count;
	}

	private static void printFamily(String[][] family) {
		System.out.println("Son     Father\n");
		for (String[] i : family) {
			for (String j : i) {
				System.out.print(j + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[][] family = getFamilyMember();
		printFamily(family);
		System.out.println("\nEnter the grandFather name to find his grandchild");
		String grandFather = sc.nextLine();

		int count = findSon(family, grandFather);

		System.out.println(grandFather + " has " + count + " grandchildren");
	}

}