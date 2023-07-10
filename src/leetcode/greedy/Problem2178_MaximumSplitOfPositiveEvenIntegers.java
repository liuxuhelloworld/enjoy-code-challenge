package leetcode.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/maximum-split-of-positive-even-integers/
 */
public class Problem2178_MaximumSplitOfPositiveEvenIntegers {
	public List<Long> maximumEvenSplit(long finalSum) {
		if (finalSum % 2 != 0) {
			return Collections.emptyList();
		}

		List<Long> split = new ArrayList<>();
		long val = 2;
		long remain = finalSum;
		while (val <= remain) {
			split.add(val);
			remain -= val;
			val += 2;
		}

		int size = split.size();
		long last = split.get(size - 1);
		split.set(size - 1, last + remain);

		return split;
	}

	public static void main(String[] args) {
		Problem2178_MaximumSplitOfPositiveEvenIntegers obj = new Problem2178_MaximumSplitOfPositiveEvenIntegers();
		System.out.println(obj.maximumEvenSplit(12));
	}
}
