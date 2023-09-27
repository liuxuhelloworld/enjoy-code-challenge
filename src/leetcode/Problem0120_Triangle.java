package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 */
public class Problem0120_Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int rows = triangle.size();

		int[] dp = new int[rows + 1];
		for (int i = 0; i <= rows; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		List<Integer> first = triangle.get(0);
		dp[1] = first.get(0);

		for (int i = 1; i < rows; i++) {
			List<Integer> cur = triangle.get(i);

			for (int j = i + 1; j >= 1; j--) {
				dp[j] = Math.min(dp[j], dp[j-1]) + cur.get(j-1);
			}
		}

		int min = dp[1];
		for (int i = 1; i <= rows; i++) {
			if (dp[i] < min) {
				min = dp[i];
			}
		}

		return min;
	}

	public static void main(String[] args) {
		Problem0120_Triangle obj = new Problem0120_Triangle();

		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		System.out.println(obj.minimumTotal(triangle));

		triangle = new ArrayList<>();
		triangle.add(Arrays.asList(-10));
		System.out.println(obj.minimumTotal(triangle));
	}
}
