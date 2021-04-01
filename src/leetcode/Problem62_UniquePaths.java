package leetcode;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class Problem62_UniquePaths {
	private int paths = 0;

	public int uniquePaths(int m, int n) {
		paths = 0;
		backtrace(0, 0, m, n);
		return paths;
	}

	private void backtrace(int curRow, int curCol, int m, int n) {
		if (curRow == m-1 && curCol == n-1) {
			paths++;
			return;
		}

		if (curCol + 1 < n) {
			backtrace(curRow, curCol+1, m, n);
		}

		if (curRow + 1 < m) {
			backtrace(curRow + 1, curCol, m, n);
		}
	}

	public int uniquePathsV2(int m, int n) {
		int[][] dp = new int[m][n]; // dp[i][j] represents the unique paths from [0,0] to [i,j]
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}

		for (int i = 1, j = 1; i < m && j < n; i++, j++) {
			for (int k = j; k < n; k++) {
				dp[i][k] = dp[i-1][k] + dp[i][k-1];
			}
			for (int k = i; k < m; k++) {
				dp[k][j] = dp[k-1][j] + dp[k][j-1];
			}
		}

		return dp[m-1][n-1];
	}

	public static void main(String[] args) {
		Problem62_UniquePaths obj = new Problem62_UniquePaths();
		System.out.println(obj.uniquePathsV2(3, 7));
	}
}
