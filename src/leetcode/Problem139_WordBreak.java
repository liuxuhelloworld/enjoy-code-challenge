package leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-break/
 */
public class Problem139_WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		int length = s.length();

		boolean[] dp = new boolean[length + 1]; // dp[i] represents whether s[0..i-1] fits wordBreak
		dp[0] = true;

		for (int i = 1; i <= length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[length];
	}

	public static void main(String[] args) {
		Problem139_WordBreak obj = new Problem139_WordBreak();
		System.out.println(obj.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
			Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
	}
}
