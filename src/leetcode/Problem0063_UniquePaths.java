package leetcode;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class Problem0063_UniquePaths {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] dp = new int[m][n];
		if (obstacleGrid[0][0] == 1) {
			dp[0][0] = 0;
		} else {
			dp[0][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = dp[i-1][0];
			}
		}
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				dp[0][j] = 0;
			} else {
				dp[0][j] = dp[0][j-1];
			}
		}

		for (int i = 1, j = 1; i < m && j < n; i++, j++) {
			for (int k = j; k < n; k++) {
				if (obstacleGrid[i][k] == 1) {
					dp[i][k] = 0;
				} else {
					dp[i][k] = dp[i-1][k] + dp[i][k-1];
				}
			}
			for (int k = i; k < m; k++) {
				if (obstacleGrid[k][j] == 1) {
					dp[k][j] = 0;
				} else {
					dp[k][j] = dp[k-1][j] + dp[k][j-1];
				}
			}
		}

		return dp[m-1][n-1];
	}

	public static void main(String[] args) {
		Problem0063_UniquePaths obj = new Problem0063_UniquePaths();
		System.out.println(obj.uniquePathsWithObstacles(new int[][] {{1, 0}}));
		System.out.println(obj.uniquePathsWithObstacles(new int[][] {{0, 1}, {1, 0}}));
		System.out.println(obj.uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
	}
}
