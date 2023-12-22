package com.elangovan16.sudhakarsan;

public class WordPyramid {
	public static void main(String[] args) {
		WordPyramid obj = new WordPyramid();
		String word = "BreakingBad";// BreakingBad,TitTat,HashAgile
		obj.printPattern(word);
	}

	private void printPattern(String word) {// 65-90
		int i = 0;
		for (i = 1; i < word.length(); i++) { // find index
			if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
				break;
			}
		}
		String word1 = word.substring(0, i).toUpperCase();
		String word2 = word.substring(i).toUpperCase();

		StringBuilder sb = new StringBuilder();
		for (i = 0; i < word1.length() || i < word2.length(); i++) {
			if (i < word1.length()) {
				sb.insert(i, word1.charAt(i));
			}
			if (i < word2.length()) {
				sb.append(word2.charAt(i));
			}
			System.out.println(sb.toString());
		}
	}
}
