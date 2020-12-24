package leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Problem22_GenerateParentheses {
	private ArrayList[] parensCache = new ArrayList[10];

	public List<String> generateParenthesis(int n) {
		return recurGenerateParenthesis(n);
	}

	private List<String> recurGenerateParenthesis(int n) {
		if (n == 0) {
			return Collections.singletonList("");
		}

		if (n == 1) {
			return Collections.singletonList("()");
		}

		if (parensCache[n] != null) {
			return parensCache[n];
		}

		List<String> all = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			List<String> parts1 = recurGenerateParenthesis(i);
			List<String> parts2 = recurGenerateParenthesis(n-1-i);
			for (String part1 : parts1) {
				for (String part2 : parts2) {
					all.add("(" + part1 + ")" + part2);
				}
			}
		}

		parensCache[n] = (ArrayList)all;

		return all;
	}

	public List<String> generateParenthesisV2(int n) {
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

	public List<String> generateParenthesisV3(int n) {
		List<String> res = new ArrayList<>();

		dfs(res, n, n, new String());

		return res;
	}

	private void dfs(List<String> res, int openLeft, int closeLeft, String s) {
		if (openLeft == 0 && closeLeft == 0) {
			res.add(s.toString());
			return;
		}

		if (openLeft > closeLeft) {
			return;
		}

		if (openLeft > 0) {
			dfs(res, openLeft-1, closeLeft, s + "(");
		}

		if (closeLeft > 0) {
			dfs(res, openLeft, closeLeft-1, s + ")");
		}
	}

	public static void main(String[] args) {
		Problem22_GenerateParentheses obj = new Problem22_GenerateParentheses();
		System.out.println(obj.generateParenthesisV3(0));
		System.out.println(obj.generateParenthesisV3(1));
		System.out.println(obj.generateParenthesisV3(2));
		System.out.println(obj.generateParenthesisV3(3));
		System.out.println(obj.generateParenthesisV3(4));
	}
}
