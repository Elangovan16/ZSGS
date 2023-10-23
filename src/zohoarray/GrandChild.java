package zohoarray;

import java.util.Scanner;

public class GrandChild {
	private static String[][] getFamilyMember() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter family count");
			int n = sc.nextInt();
			sc.nextLine();
			String[][] arr = new String[n][2];
			for (int i = 0; i < arr.length; i++) {
				System.out.println("Enter son name and father name");
				for (int j = 0; j < 2; j++) {
					arr[i][j] = sc.nextLine();
				}
			}
			return arr;
		}
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

	@SuppressWarnings("unused")
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
		Scanner sc = new Scanner(System.in);

		String[][] family = getFamilyMember();
		printFamily(family);
		System.out.println("Enter the grandFather name to find his grandchild");
		String grandFather = sc.nextLine();
		sc.close();
		int count = findSon(family, grandFather);

		System.out.println(grandFather + " has " + count + " grandchildren");
	}
}