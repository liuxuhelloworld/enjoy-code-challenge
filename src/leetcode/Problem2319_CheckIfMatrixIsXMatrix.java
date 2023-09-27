package leetcode;

/**
 * https://leetcode.cn/problems/check-if-matrix-is-x-matrix/
 */
public class Problem2319_CheckIfMatrixIsXMatrix {
	public boolean checkXMatrix(int[][] grid) {
		int n = grid.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || i+j == n-1) {
					if (grid[i][j] == 0) {
						return false;
					}
				} else {
					if (grid[i][j] != 0) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Problem2319_CheckIfMatrixIsXMatrix obj = new Problem2319_CheckIfMatrixIsXMatrix();
		int[][] grid = new int[][] {
			{2,0,0,1},
			{0,3,1,0},
			{0,5,2,0},
			{4,0,0,2}};
		System.out.println(obj.checkXMatrix(grid));
	}
}
