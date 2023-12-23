package com.elangovan16.leetcode;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
	public static void main(String[] args) {
		PathCrossing obj = new PathCrossing();
		String path = "NESWW";
		obj.isPathCrossing(path);
	}

	public boolean isPathCrossing(String path) {
		Set<String> seen = new HashSet<String>();
		int x = 0;
		int y = 0;
		seen.add(x + "," + y);
		for (char c : path.toCharArray()) {
			if (c == 'N') {
				x++;
			} else if (c == 'S') {
				x--;
			} else if (c == 'E') {
				y++;
			} else {
				y--;
			}
			String s = x + "," + y;
			if (seen.contains(s)) {
				return true;
			}
			seen.add(s);
		}
		return false;
	}
}
