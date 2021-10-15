package leetcode.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Problem198_HouseRobber {
	public int rob(int[] nums) {
		int len = nums.length;

		int[] dp = new int[len+1];
		dp[0] = 0;
		dp[1] = nums[0];

		for (int i = 2; i <= len; i++) {
			int robWithI = nums[i-1] + dp[i-2];
			int robWithoutI = dp[i-1];
			dp[i] = Math.max(robWithI, robWithoutI);
		}

		return dp[len];
	}

	public static void main(String[] args) {
		Problem198_HouseRobber obj = new Problem198_HouseRobber();
		System.out.println(obj.rob(new int[] {1, 2, 3, 1}));
		System.out.println(obj.rob(new int[] {2, 7, 9, 3, 1}));
	}
}
