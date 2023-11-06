package com.elangovan16;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Home {

	private static void loadPackage(ArrayList<File> packageList) {
		File p = new File("src/com/elangovan16");
		File[] files = p.listFiles();
		for (File f : files) {
			if (f.isDirectory())
				packageList.add(f);
		}
	}

	private static void displayPackage(ArrayList<File> packageList) {
		int index = 1;
		System.out.println("\n-------Packages-------\n");
		for (File f : packageList) {
			System.out.println(index++ + ". " + f.getName());
		}
		System.out.println();
	}

	private static void loadClass(File packageFile, ArrayList<File> classList) {
		if (!classList.isEmpty()) {
			classList.clear();
		}
		for (File f : packageFile.listFiles()) {
			if (f.isFile())
				classList.add(f);
		}
	}

	private static void displayClass(ArrayList<File> classList) {
		System.out.println("\n-------Class Files-------\n");
		int index = 1;
		for (File f : classList) {
			System.out.println(index++ + ". " + f.getName().replace(".java", ""));
		}
	}

	private static void invokeClass(File classFile) {
		try {
			String className = classFile.getPath().substring(4).replace("/", ".").replace(".java", "");
			Class<?> c = Class.forName(className);
			Method m = c.getDeclaredMethod("main", String[].class);
			String[] args = new String[0];
			m.invoke(null, (Object) args);
		} catch (Exception e) {
			System.out.println("\nError : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<File> packageList = new ArrayList<File>();
		ArrayList<File> classList = new ArrayList<File>();
		boolean flag = true;
		loadPackage(packageList);

		do {
			displayPackage(packageList);
			System.out.println("-1 for Exit... ");
			System.out.println("Enter Valid Number : ");
			if (sc.hasNextInt()) {
				int n = sc.nextInt();
				if (n > 0 && n <= packageList.size()) {
					File packageFile = packageList.get(n - 1);
					loadClass(packageFile, classList);
					displayClass(classList);
					System.out.println("\nEnter Valid Number : ");
					int fileIndex = sc.nextInt();
					if (fileIndex > 0 && fileIndex <= classList.size()) {
						invokeClass(classList.get(fileIndex - 1));
					}
				} else if (n > packageList.size()) {
					System.out.print("\nEnter an Valid Input");
					continue;
				} else if (n == -1) {
					flag = false;
				}
			} else {
				System.out.println("Invalid input. Please enter a valid number.");
			}
		} while (flag);
		sc.close();
	}

}
