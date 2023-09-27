package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class Problem47_Permutations {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> permutation = new ArrayList<>();

		boolean[] tag = new boolean[nums.length];

		Arrays.sort(nums);

		backtrack(result, permutation, nums, tag, 0);

		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> permutation, int[] nums, boolean[] tag, int cur) {
		if (cur == nums.length) {
			result.add(new ArrayList<>(permutation));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (tag[i] == true
				|| (i > 0 && nums[i] == nums[i-1] && !tag[i-1])) {
				continue;
			}

			tag[i] = true;
			permutation.add(nums[i]);
			backtrack(result, permutation, nums, tag, cur+1);
			permutation.remove(permutation.size()-1);
			tag[i] = false;
		}
	}

	public static void main(String[] args) {
		Problem47_Permutations obj = new Problem47_Permutations();
		System.out.println(obj.permuteUnique(new int[] {1, 2, 2, 3, 3}));
	}
}
