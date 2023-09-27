package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class Problem0078_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();

		backtrack(subsets, subset, nums, 0);

		return subsets;
	}

	private void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int cur) {
		if (cur == nums.length) {
			subsets.add(new ArrayList<>(subset));
			return;
		}

		// cur excluded
		backtrack(subsets, subset, nums, cur + 1);

		// cur included
		subset.add(nums[cur]);
		backtrack(subsets, subset, nums, cur + 1);
		subset.remove(subset.size() - 1);
	}

	public static void main(String[] args) {
		Problem0078_Subsets obj = new Problem0078_Subsets();
		System.out.println(obj.subsets(new int[] {1, 2, 3}));
		System.out.println(obj.subsets(new int[] {0}));
	}
}
