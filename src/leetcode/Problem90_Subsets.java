package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class Problem90_Subsets {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();

		Arrays.sort(nums);

		List<int[]> numsCount = new ArrayList<>();
		Arrays.stream(nums).forEach(num -> {
			if (numsCount.size() > 0 && numsCount.get(numsCount.size() - 1)[0] == num) {
				numsCount.get(numsCount.size() - 1)[1] += 1;
			} else {
				numsCount.add(new int[] {num, 1});
			}
		});

		backtrack(subsets, subset, numsCount, 0);

		return subsets;
	}

	private void backtrack(List<List<Integer>> subsets, List<Integer> subset, List<int[]> numsCount, int idx) {
		if (idx == numsCount.size()) {
			subsets.add(new ArrayList<>(subset));
			return;
		}

		int[] cur = numsCount.get(idx);
		int num = cur[0], count = cur[1];
		for (int i = 0; i <= count; i++) {
			for (int j = 0; j < i; j++) {
				subset.add(num);
			}

			backtrack(subsets, subset, numsCount, idx + 1);

			for (int j = 0; j < i; j++) {
				subset.remove(subset.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Problem90_Subsets obj = new Problem90_Subsets();
		System.out.println(obj.subsetsWithDup(new int[] {1, 2, 2}));
		System.out.println(obj.subsetsWithDup(new int[] {0}));
	}
}
