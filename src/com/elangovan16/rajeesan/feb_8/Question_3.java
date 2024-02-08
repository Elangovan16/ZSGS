package com.elangovan16.rajeesan.feb_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Stock implements Comparable<Stock> {
	private String name;
	private float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Stock(String name, float price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public int compareTo(Stock o) {
		return (int) (o.price - this.price);
	}

	@Override
	public String toString() {
		return String.format("Stock Name: %s, Price: %.2f", getName(), getPrice());
	}
}

public class Question_3 {
	public static void main(String[] args) {
		readCSV();
		printCSV();
	}

	private static void printCSV() {
		File file = new File("src/com/elangovan16/rajeesan/feb_8/output.csv");
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
		}

	}

	public static void readCSV() {
		File file = new File("src/com/elangovan16/rajeesan/feb_8/input.csv");
		String heading = null;
		List<Stock> stock = new ArrayList<>();
		String name;
		float price;
		try {
			Scanner sc = new Scanner(file);
			sc.useDelimiter(",|\n");
			if (sc.hasNextLine()) {
				heading = sc.nextLine();
			}

			while (sc.hasNext()) {
				name = sc.next();
				price = sc.nextFloat();

				stock.add(new Stock(name, price));
//				System.out.println(name + " " + price);
			}

			sc.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
		}
		writeCSV(heading, stock);
	}

	private static void writeCSV(String heading, List<Stock> stock) {
		File file = new File("src/com/elangovan16/rajeesan/feb_8/output.csv");
		String[] head = heading.split(",");
		Collections.sort(stock);
		try {
			PrintWriter pw = new PrintWriter(file);

			pw.printf("%s, %s \n", head[0], head[1]);

			for (Stock s : stock) {
				pw.printf("%s, %.2f \n", s.getName(), s.getPrice());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
		}
	}
}
