package leetcode;

import java.util.*;

/**
 * https://leetcode.cn/problems/minimum-interval-to-include-each-query/
 */
public class Problem1851_MinimumIntervalToIncludeEachQuery {
	public int[] minInterval(int[][] intervals, int[] queries) {
		int[] result = new int[queries.length];
		Arrays.fill(result, -1);

		Integer[] queriesIdx = new Integer[queries.length];
		for (int i = 0; i < queriesIdx.length; i++) {
			queriesIdx[i] = i;
		}
		Arrays.sort(queriesIdx, Comparator.comparingInt(i -> queries[i]));

		Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
			(interval1, interval2) -> interval1[1] - interval1[0] - interval2[1] + interval2[0]);

		int i = 0;
		int intervalIdx = 0;
		while (i < queriesIdx.length) {
			int queryIdx = queriesIdx[i];
			int query = queries[queryIdx];

			while (intervalIdx < intervals.length && intervals[intervalIdx][0] <= query) {
				priorityQueue.offer(intervals[intervalIdx]);
				intervalIdx++;
			}

			while (!priorityQueue.isEmpty()) {
				int[] curInterval = priorityQueue.peek();
				if (curInterval[1] < query) {
					priorityQueue.poll();
				} else {
					result[queryIdx] = curInterval[1] - curInterval[0] + 1;
					break;
				}
			}

			i++;
		}

		return result;
	}

	public static void main(String[] args) {
		Problem1851_MinimumIntervalToIncludeEachQuery obj =
			new Problem1851_MinimumIntervalToIncludeEachQuery();

		int[][] intervals = new int[][] {
			{2, 3},
			{2, 5},
			{1, 8},
			{20, 25}};
		int[] queries = new int[] {2,19,5,22};

		int[] ret = obj.minInterval(intervals, queries);
		System.out.println(Arrays.toString(ret));
	}
}
