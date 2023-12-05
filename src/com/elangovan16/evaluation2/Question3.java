package com.elangovan16.evaluation2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question3 {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		Question3 q3 = new Question3();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = sc.nextLine();
		q3.splitWord(str, words);
		String word[]=q3.getWordWithNumber(words);
		System.out.println("Output : ");
		for(int i=0;i<word.length;i++) {
			System.out.print(word[i]+", ");
		}
	}


	private String[] getWordWithNumber(ArrayList<String> words) {
		HashMap<String,Integer> hm=new HashMap<>();
		for(int i=0;i<words.size();i++) {
			String word=words.get(i); 
			if(!hm.containsKey(word)) {
				hm.put(word, 1);
			}
			else {
				int count=hm.get(word);
				hm.put(word, count+1);
			}
		}
		String[] str=getWord(hm);
		sortWord(str);
		return str;
	}

	private void sortWord(String[] str) {
		for(int i=0;i<str.length;i++) {
			for(int j=i+1;j<str.length;j++) {
				if((str[i].charAt(str[i].length()-1)-'0')<((str[j].charAt(str[j].length()-1)-'0'))){
					String temp=str[i];
					str[i]=str[j];
					str[j]=temp;
				}
			}
		}
	}

	private String[] getWord(HashMap<String, Integer> hm) {
		String[] arr=new String[hm.size()];
		int index=0;
		for(Map.Entry<String,Integer> entry:hm.entrySet()) {
			arr[index++]=entry.getKey()+" -"+entry.getValue();
		}
		return arr;
	}


	private void splitWord(String str, ArrayList<String> words) {
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
