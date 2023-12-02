package com.elangovan16.evaluation2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Question3 {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		Question3 q3 = new Question3();
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the String : ");
//		String str = sc.nextLine();
		String str="Hello world Hello world broo broo is it is it";
		q3.getWord(str, words);
		System.out.println(words);
		String word[]=q3.getWordWithNumber(words);
	}


	private String[] getWordWithNumber(ArrayList<String> words) {
		HashMap<String,Integer> hm=new HashMap<>();
		for(int i=0;i<words.size();i++) {
			String word=words.get(i); 
			if(!hm.containsKey(words.get(i))) {
				hm.put(words.get(i), 1);
			}
			
		}
		return null;
	}


	private void getWord(String str, ArrayList<String> words) {
		String word = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				words.add(word);
				word="";
			}
			if(str.charAt(i) != ' ') {
				word+=str.charAt(i);
			}
		}
		words.add(word);
	}
}
