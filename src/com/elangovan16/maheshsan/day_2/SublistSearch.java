package com.elangovan16.maheshsan.day_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SublistSearch {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SublistSearch obj = new SublistSearch();
		List<Integer> mainList = obj.getValue(true);
		List<Integer> subList = obj.getValue(false);
		System.out.println(obj.isSubList(mainList, subList));
	}

	private boolean isSubList(List<Integer> mainList, List<Integer> subList) {
		int mainLen=mainList.size();
		int subLen=subList.size();
		for(int i=0;i<=mainLen-subLen;i++) {
			int j=0;
			for(j=0;j<subLen;j++) {
				if(mainList.get(i+j)!=subList.get(j)) {
					break;
				}
			}
			if(j==subLen) {
				return true;
			}
		}
		return false;
	}

	private List<Integer> getValue(boolean flag) {
		List<Integer> list = new ArrayList<>();
		if (flag) {
			System.out.print("Enter MainList size : ");
		} else {
			System.out.print("Enter SubList Size : ");
		}
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("Enter " + i + " element : ");
			list.add(sc.nextInt());
		}
		System.out.println();
		return list;
	}
}
