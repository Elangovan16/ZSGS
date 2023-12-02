package com.elangovan16.evaluation2;

import java.util.Scanner;
public class Question2 {
	public static void main(String[] args) {
		Question2 q2=new Question2();
		int[][] mat=q2.getMatrix();
		System.out.println("Input");
		q2.printMatrix(mat);
		System.out.println("Output");
		mat=q2.transposedMatrix(mat);
		q2.printMatrix(mat);
	}
	private int[][] getMatrix(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Row : ");
		int row=sc.nextInt();
		System.out.println("Entre the Column : ");
		int column=sc.nextInt();
		int[][] mat=new int[row][column];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				System.out.print("Enter the Number for "+i +" "+j+" :");
				mat[i][j]=sc.nextInt();
			}
			System.out.println();
		}
		return mat;
	}
	private int[][] transposedMatrix(int[][] mat) {
		int row=mat.length;
		int column=mat[0].length;
		int[][] transMat=new int[column][row];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				transMat[j][i]=mat[i][j];
			}
		}
		return transMat;
	}
	private void printMatrix(int[][] mat) {
		for(int[] i:mat) {
			for(int j:i) {
				System.out.printf("%2d ",j);
			}
			System.out.println();
		}
	}
}
