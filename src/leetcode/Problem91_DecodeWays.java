package leetcode;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class Problem91_DecodeWays {
	public int numDecodings(String s) {
		assert s != null && s.length() > 0;

		int len = s.length();

		int[] dp = new int[len + 1];
		dp[0] = 1;

		if (isValid(s.substring(0, 1))) {
			dp[1] = 1;
		} else {
			return 0;
		}

		for (int i = 2; i <= len; i++) {
			String sub = s.substring(i-1, i);
			if (isValid(sub)) {
				dp[i] += dp[i-1];
			}

			sub = s.substring(i-2, i);
			if (isValid(sub)) {
				dp[i] += dp[i-2];
			}

			if (dp[i] == 0) {
				return 0;
			}
		}

		return dp[len];
	}

	private boolean isValid(String s) {
		int len = s.length();

		if (len == 0 || len > 2) {
			return false;
		}

		int val = Integer.parseInt(s);
		if (len == 1 && val != 0) {
			return true;
		}
		if (len == 2 && val >= 10 && val <= 26) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Problem91_DecodeWays obj = new Problem91_DecodeWays();
		System.out.println(obj.numDecodings("12"));
		System.out.println(obj.numDecodings("226"));
		System.out.println(obj.numDecodings("0"));
		System.out.println(obj.numDecodings("06"));
	}
}
