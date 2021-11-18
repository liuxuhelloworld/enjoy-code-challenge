package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Problem22_GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();

		dfs(res, n, n, new String());

		return res;
	}

	private void dfs(List<String> res, int openLeft, int closeLeft, String s) {
		if (openLeft == 0 && closeLeft == 0) {
			res.add(s);
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
		System.out.println(obj.generateParenthesis(3));
		System.out.println(obj.generateParenthesis(1));
		System.out.println(obj.generateParenthesis(2));
		System.out.println(obj.generateParenthesis(3));
		System.out.println(obj.generateParenthesis(4));
	}
}
