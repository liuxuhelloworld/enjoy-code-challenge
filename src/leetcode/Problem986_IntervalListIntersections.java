package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/interval-list-intersections/
 */
public class Problem986_IntervalListIntersections {
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		int m = firstList.length;
		int n = secondList.length;

		List<List<Integer>> intersectionList = new ArrayList<>();

		int i = 0, j = 0;
		while (i < m && j < n) {
			int[] curFirst = firstList[i];
			int[] curSecond = secondList[j];

			List<Integer> curIntersection = new ArrayList<>(2);

			int low = Math.max(curFirst[0], curSecond[0]);
			int high = Math.min(curFirst[1], curSecond[1]);
			if (low <= high) {
				curIntersection.add(low);
				curIntersection.add(high);

				intersectionList.add(curIntersection);
			}

			if (curFirst[1] < curSecond[1]) {
				i++;
			} else {
				j++;
			}
		}

		int size = intersectionList.size();

		if (size == 0) {
			return new int[][] {};
		}

		int[][] intersections = new int[size][2];
		for (i = 0; i < intersections.length; i++) {
			List<Integer> cur = intersectionList.get(i);
			intersections[i][0] = cur.get(0);
			intersections[i][1] = cur.get(1);
		}

		return intersections;
	}

	public static void main(String[] args) {
		Problem986_IntervalListIntersections obj = new Problem986_IntervalListIntersections();

		int[][] first = new int[][] {{3, 5}, {9, 20}};
		int[][] second = new int[][] {{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}};
		System.out.println(Arrays.toString(obj.intervalIntersection(first, second)));

		first = new int[][] {{1, 3}, {5, 9}};
		second = new int[][] {};
		System.out.println(Arrays.toString(obj.intervalIntersection(first, second)));
	}
}
