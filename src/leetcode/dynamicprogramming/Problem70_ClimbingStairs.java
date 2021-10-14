package leetcode.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Problem70_ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	public static void main(String[] args) {
		Problem70_ClimbingStairs obj = new Problem70_ClimbingStairs();
		System.out.println(obj.climbStairs(2));
		System.out.println(obj.climbStairs(3));
		System.out.println(obj.climbStairs(5));
	}
}
