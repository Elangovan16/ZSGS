package com.elangovan16.leetcode;

import java.util.Scanner;
public class MinimumTime {//1266. Minimum Time Visiting All Points
	public static void main(String[] args) {
		MinimumTime minimumTime=new MinimumTime();
		int[][] points = {{1,1},{3,4},{-1,0}};
		int seconds=minimumTime.minTimeToVisitAllPoints(points);
		System.out.println(seconds);
	}
	public int minTimeToVisitAllPoints(int[][] points) {
        int second=0;
        int N=points.length;

        for(int i=0;i < N-1;i++){
            int x_diff=Math.abs(points[i][0]-points[i+1][0]);
            int y_diff=Math.abs(points[i][1]-points[i+1][1]);

            if(x_diff < y_diff){
                second += x_diff;
                second += y_diff - x_diff;
            }
            else{
                second += y_diff;
                second += x_diff - y_diff;
            }
        }
        return second;
    }
}