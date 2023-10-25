package zohoarray;

import java.util.Arrays;
import java.util.Scanner;

public class RearrangeArray {
	private static int[] getNumbers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Elements");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the number");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		return arr;
	}

	private static int[] reArrange(int[] arr) {
		int[] tempArr = new int[arr.length];
		int start = 0;
		int end = arr.length - 1;
		for (int i = end; i >= 0; i--) {
			if (i % 2 != 0) {
				tempArr[i] = arr[end];
				end--;
			} else {
				tempArr[i] = arr[start];
				start++;
			}
		}
		return tempArr;
	}

	private static void printArray(int arr[]) {
		for (int a : arr) {
			System.out.print(a + "  ");
		}
	}

	public static void main(String[] args) {
		int[] nums = getNumbers();
		Arrays.sort(nums);
		int[] rearrangedNums = reArrange(nums);
		printArray(rearrangedNums);
	}
}
