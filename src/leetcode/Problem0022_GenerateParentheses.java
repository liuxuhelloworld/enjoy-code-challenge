package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Problem0022_GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();

		backtrack(res, n, n, new String());

		return res;
	}

	private void backtrack(List<String> res, int openLeft, int closeLeft, String s) {
		if (openLeft == 0 && closeLeft == 0) {
			res.add(s);
			return;
		}

		if (openLeft > closeLeft) {
			return;
		}

		if (openLeft > 0) {
			backtrack(res, openLeft-1, closeLeft, s + "(");
		}

		if (closeLeft > 0) {
			backtrack(res, openLeft, closeLeft-1, s + ")");
		}
	}

	public List<String> generateParenthesis2(int n) {
		if (n <= 0) {
			return Collections.singletonList("");
		}

		if (n == 1) {
			return Collections.singletonList("()");
		}

		List<String>[] dp = new List[n+1];
		dp[0] = Collections.singletonList("");
		dp[1] = Collections.singletonList("()");
		for (int i = 2; i < dp.length; i++) {
			List<String> all = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				List<String> parts1 = dp[j];
				List<String> parts2 = dp[i-1-j];

				for (String part1 : parts1) {
					for (String part2 : parts2) {
						all.add("(" + part1 + ")" + part2);
					}
				}
			}

			dp[i] = all;
		}

		return dp[n];
	}

	public static void main(String[] args) {
		Problem0022_GenerateParentheses obj = new Problem0022_GenerateParentheses();
		System.out.println(obj.generateParenthesis(3));
		System.out.println(obj.generateParenthesis(1));
		System.out.println(obj.generateParenthesis(2));
		System.out.println(obj.generateParenthesis(3));
		System.out.println(obj.generateParenthesis(4));
	}
}
