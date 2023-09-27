package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class Problem0077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		if (k > n) {
			return Collections.emptyList();
		}

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();

		backtrack(result, combination, 1, n, k);

		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> combination, int cur, int n, int k) {
		if (combination.size() == k) {
			result.add(new ArrayList<>(combination));
			return;
		}

		if (cur > n
			|| (n-cur+1) < (k-combination.size())) {
			return;
		}

		combination.add(cur);
		backtrack(result, combination, cur+1, n, k);
		combination.remove(combination.size() - 1);

		backtrack(result, combination, cur+1, n, k);
	}

	public static void main(String[] args) {
		Problem0077_Combinations obj = new Problem0077_Combinations();
		System.out.println(obj.combine(1, 1));
		System.out.println(obj.combine(4, 2));
	}
}
