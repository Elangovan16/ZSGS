package com.elangovan16.evaluation2;
import java.util.Scanner;
public class Question1 {
	public static void main(String[] args) {
		Question1 q1=new Question1();
		int[] arr= q1.getArray();
		System.out.println("Input");
		q1.printArray(arr);
		int[] ans=findMaxArray(arr,arr.length);
		System.out.println("Output");
		q1.printArray(ans);
	}
	private void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ,");
		}
		System.out.println();
	}
	private static int[] findMaxArray(int[] arr,int n) {
		int max=0;
		int count=0;
		int maxJ=0;
		int maxK=0;
		int maxCount=0;
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=n-i;j++) {
				int temp=0;
				count=0;
				for(int k=j;k<i+j&&k<n;k++) {
					temp+=arr[k];
					count+=1;
					if(temp>=max) {
						max=temp;
						maxJ=j;
						maxK=k;
						maxCount=count;
						count=0;
					}
				}
			}
		}

		int[] maxArray=new int[maxCount];
		count=0;
		for(int i=maxJ;i<=maxK;i++) {
			maxArray[count++]=arr[i];
		}
		return maxArray;
	}
	private int[] getArray() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Array length : ");
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("Enter the "+i+" Element : ");
			arr[i]=sc.nextInt();
		}
		return arr;
	}
}
