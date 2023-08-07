package leetcode;

import java.util.*;

/**
 * https://leetcode.cn/problems/minimum-interval-to-include-each-query/
 */
public class Problem1851_MinimumIntervalToIncludeEachQuery {
	public int[] minInterval(int[][] intervals, int[] queries) {
		Set<Integer> nums = new HashSet<>();
		Map<Integer, Integer> sizeMap = new HashMap<>();

		for (int i = 0; i < intervals.length; i++) {
			int[] interval = intervals[i];
			int left = interval[0];
			int right = interval[1];

			int size = right - left + 1;

			for (int j = left; j <= right; j++) {
				if (!nums.contains(j)) {
					nums.add(j);
					sizeMap.put(j, size);
				} else {
					if (sizeMap.get(j) > size) {
						sizeMap.put(j, size);
					}
				}
			}
		}

		int[] ret = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int query = queries[i];
			if (!nums.contains(query)) {
				ret[i] = -1;
			} else {
				ret[i] = sizeMap.get(query);
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem1851_MinimumIntervalToIncludeEachQuery obj =
			new Problem1851_MinimumIntervalToIncludeEachQuery();

		int[][] intervals = new int[][] {
			{1, 4},
			{2, 4},
			{3, 6},
			{4, 4}};
		int[] queries = new int[] {2,3,4,5};

		int[] ret = obj.minInterval(intervals, queries);
		System.out.println(Arrays.toString(ret));
	}
}
