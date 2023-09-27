package leetcode;

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

		List<List<Long>> splits = new ArrayList<>();
		List<Long> split = new ArrayList<>();
		backtrack(splits, split, 0, finalSum);

		if (splits.isEmpty()) {
			return Collections.emptyList();
		}

		int maxSize = 0;
		int maxIdx = -1;
		for (int i = 0; i < splits.size(); i++) {
			split = splits.get(i);
			if (split.size() > maxSize) {
				maxSize = split.size();
				maxIdx = i;
			}
		}

		return splits.get(maxIdx);
	}

	private void backtrack(List<List<Long>> splits, List<Long> split, long last, long remain) {
		if (remain == 0) {
			splits.add(new ArrayList<>(split));
			return;
		}

		if (last > remain) {
			return;
		}

		long next = last + 2;
		while (next <= remain) {
			split.add(next);
			backtrack(splits, split, next, remain - next);
			split.remove(split.size() - 1);

			next += 2;
		}
	}

	public List<Long> maximumEvenSplit2(long finalSum) {
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
		System.out.println(obj.maximumEvenSplit(28));
	}
}
