package com.elangovan16.leetcode;

import java.util.Arrays;

public class SortVowelsInAString {
	public static void main(String[] args) {//2785. Sort Vowels in a String
		SortVowelsInAString obj=new SortVowelsInAString();
		String s = "lEetcOde";//output-"lEOtcede"
		System.out.println(obj.sortVowels(s));
	}

	public String sortVowels(String s) {
		char[] arr=s.toCharArray();
		StringBuilder vowel = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(isVowel(arr[i])){
				vowel.append(arr[i]);
				arr[i]='_';
			}
		}
		
		char[] vowelArr=vowel.toString().toCharArray();
		Arrays.sort(vowelArr);
		StringBuilder ans = new StringBuilder();
		int index=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='_') {
				ans.append(vowelArr[index++]);
			}
			else {
				ans.append(arr[i]);
			}
		}
		return ans.toString();
	}

	public boolean isVowel(char c) {
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o'
				|| c == 'u') {
			return true;
		}
		return false;
	}
}
