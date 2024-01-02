package com.elangovan16.rolehierarchy.util;

import java.util.Scanner;

public class Get {
	static Scanner sc = new Scanner(System.in);

	public static byte getByte() {
		byte n;
		while (true) {
			if (sc.hasNextByte()) {
				n = sc.nextByte();
				sc.nextLine();
				return n;
			}
			sc.nextLine();
			System.out.println("Enter Valid ");
		}
	}

	public static String getPath() {
		String path = "src/com/elangovan16/rolehierarchy/repository/Data.json";
		return path;
	}
}
