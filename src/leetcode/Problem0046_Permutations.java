package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class Problem0046_Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> permutation = new ArrayList<>();

		boolean[] tag = new boolean[nums.length];

		backtrack(result, permutation, nums, tag, 0);

		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> permutation, int[] nums, boolean[] tag, int cur) {
		if (cur == nums.length) {
			result.add(new ArrayList<>(permutation));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (tag[i] == false) {
				tag[i] = true;
				permutation.add(nums[i]);
				backtrack(result, permutation, nums, tag, cur+1);
				permutation.remove(permutation.size()-1);
				tag[i] = false;
			}
		}
	}

	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> numList = Arrays.stream(nums)
			.boxed()
			.collect(Collectors.toList());

		backtrack2(result, numList, 0);

		return result;
	}

	private void backtrack2(List<List<Integer>> result, List<Integer> nums, int cur) {
		if (cur == nums.size()) {
			result.add(new ArrayList<>(nums));
			return;
		}

		for (int i = cur; i < nums.size(); i++) {
			Collections.swap(nums, i, cur);
			backtrack2(result, nums, cur+1);
			Collections.swap(nums, i, cur);
		}
	}

	public static void main(String[] args) {
		Problem0046_Permutations obj = new Problem0046_Permutations();
		System.out.println(obj.permute2(new int[] {1, 2, 3}));
	}
}
