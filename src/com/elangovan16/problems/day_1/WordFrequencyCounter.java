package com.elangovan16.problems.day_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WordFrequencyCounter obj = new WordFrequencyCounter();
		Map<String, Integer> map = new HashMap<>();
		System.out.println("Enter the String : ");
		String para = sc.nextLine();
		String[] words = para.toLowerCase().split(" ");
		System.out.println(Arrays.toString(words));

		obj.punctuatoinFinder(words);

		obj.getWorldWithFrequency(words, map);

		obj.printWorldWithFrequency(map);

	}

	private void printWorldWithFrequency(Map<String, Integer> map) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey() + " - ").append(entry.getValue() + ", ");
		}
		System.out.println(sb.toString());
	}

	private void getWorldWithFrequency(String[] words, Map<String, Integer> map) {
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}
	}

	private String ignorePunctuatoin(String word) {
		String s = word.replaceAll("[^a-zA-Z0-9]", "");
		return s;
	}

	private void punctuatoinFinder(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (!words[i].matches("[^a-zA-Z0-9]"))
				words[i] = ignorePunctuatoin(words[i]);
		}
	}
}
