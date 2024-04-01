package com.elangovan16.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach { // 1642. Furthest Building You Can Reach
	public static void main(String[] args) {
		int[] heights = { 4, 2, 7, 6, 9, 14, 12 };
		int bricks = 5;
		int ladders = 1;
		int res = furthestBuilding(heights, bricks, ladders);
		System.out.println("Output : " + res);
	}

	public static int furthestBuilding(int[] h, int b, int l) {
		Queue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < h.length - 1; i++) {
			if (h[i + 1] - h[i] > 0) {
				pq.offer(h[i + 1] - h[i]);
			}
			if (pq.size() > l) {
				if (pq.peek() <= b) {
					b -= pq.poll();
				} else
					return i;
			}
		}
		return h.length - 1;
	}
}