package leetcode.array;

/**
 * https://leetcode.cn/problems/equal-row-and-column-pairs/
 */
public class Problem2352_EqualRowAndColumnPairs {
	public int equalPairs(int[][] grid) {
		int length = grid.length;

		int cnt = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (isEqual(grid, i, j)) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	private boolean isEqual(int[][] grid, int rowIdx, int columnIdx) {
		int[] row = grid[rowIdx];
		for (int i = 0; i < row.length; i++) {
			if (row[i] != grid[i][columnIdx]) {
				return false;
			}
		}

		return true;
	}
}
