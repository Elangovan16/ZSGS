package com.elangovan16.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SplitStringsBySeparator {
	public static void main(String[] args) {
		List<String> words=new ArrayList<>(List.of("one.two.three","four.five","six"));
		char separator='.';
		splitWordsBySeparator(words,separator);
	}
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
    	List<String> ans=new ArrayList<>();
    	int index;
    	for(int i=0;i<words.size();i++) {
    		index=0;
    		String str=words.get(i);
    		while(index<str.length()) {
    			
    		}
    	}
		return words;
    }
}
