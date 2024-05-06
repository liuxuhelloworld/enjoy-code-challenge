package leetcode;

/**
 * https://leetcode-cn.com/problems/interleaving-string/
 */
public class Problem0097_InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		assert s1 != null && s2 != null && s3 != null;

		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();

		if (len1 + len2 != len3) {
			return false;
		}

		if (len1 == 0 && len2 == 0 && len3 == 0) {
			return true;
		}

		boolean[][] dp = new boolean[len1 + 1][len2 + 1];

		int matches1 = matches(s1, s3);
		for (int len = 1; len <= matches1; len++) {
			dp[len][0] = true;
		}

		int matches2 = matches(s2, s3);
		for (int len = 1; len <= matches2; len++) {
			dp[0][len] = true;
		}

		for (int sum = 2; sum <= len1 + len2; sum++) {
			for (int i = 1; i <= sum; i++) {
				int j = sum - i;

				if (i <= 0 || i > len1 || j <= 0 || j > len2) {
					continue;
				}

				if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = dp[i][j] || dp[i - 1][j];
				}
				if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = dp[i][j] || dp[i][j - 1];
				}
			}
		}

		return dp[len1][len2];
	}

	private int matches(String s, String t) {
		int cnt = 0;
		for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
			if (s.charAt(i) == t.charAt(j)) {
				cnt++;
			} else {
				break;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		Problem0097_InterleavingString obj = new Problem0097_InterleavingString();
		System.out.println(obj.isInterleave("aa", "ab", "abaa"));
		System.out.println(obj.isInterleave("aabcc", "dbbca", "aadbcbbcac"));
		System.out.println(obj.isInterleave("", "", ""));
		System.out.println(obj.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
