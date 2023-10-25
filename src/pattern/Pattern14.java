package pattern;

import java.util.Scanner;

public class Pattern14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = sc.nextInt();
		sc.close();
		printPattern(n);
	}

	private static void printPattern(int n) {
		for (int i = 1; i <= 2 * n - 1; i++) {
			for (int j = 1; j <= 2 * n; j++) {
				if (i + j >= 2 && i + j <= 2 * n && i >= j)
					System.out.print("*");
				else if (i + j - 1 >= 2 * n && i + j <= 3 * n && j > i)
					System.out.print("*");
				else if (i + j >= n + 2 && i + j <= 2 * n && i >= j)
					System.out.print("*");
				else if (i + j >= 2 * n + 3 && i + j <= 4 * n - 1 && j > i)
					System.out.print("*");
				else
					System.out.print(" ");

			}
			System.out.println();
		}
	}
}
