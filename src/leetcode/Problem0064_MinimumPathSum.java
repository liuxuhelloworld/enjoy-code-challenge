package leetcode;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class Problem0064_MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];

		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for (int j = 1; j < n; j++) {
			dp[0][j] = dp[0][j-1] + grid[0][j];
		}

		for (int i = 1, j = 1; i < m && j < n; i++, j++) {
			dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];

			for (int k = j+1; k < n; k++) {
				dp[i][k] = Math.min(dp[i-1][k], dp[i][k-1]) + grid[i][k];
			}
			for (int k = i+1; k < m; k++) {
				dp[k][j] = Math.min(dp[k-1][j], dp[k][j-1]) + grid[k][j];
			}
		}

		return dp[m-1][n-1];
	}

	public static void main(String[] args) {
		Problem0064_MinimumPathSum obj = new Problem0064_MinimumPathSum();
		System.out.println(obj.minPathSum(new int[][] {{1}}));
	}
}
