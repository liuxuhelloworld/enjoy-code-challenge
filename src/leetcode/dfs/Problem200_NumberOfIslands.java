package leetcode.dfs;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class Problem200_NumberOfIslands {
	private int[] dx = {-1, 1, 0, 0};
	private int[] dy = {0, 0, -1, 1};

	public int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		boolean[][] visited = new boolean[m][n];

		int num = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1'
					&& !visited[i][j]) {
					num++;
					dfs(grid, i, j, visited);
				}
			}
		}

		return num;
	}

	private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
		if (visited[i][j]
			|| grid[i][j] == '0') {
			return;
		}

		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (isValidIndex(grid, x, y)
				&& grid[x][y] == '1'
				&& !visited[x][y] ) {
				dfs(grid, x, y, visited);
			}
		}
	}

	private boolean isValidIndex(char[][] grid, int i, int j) {
		int m = grid.length;
		int n = grid[0].length;

		if (i < 0 || i >= m) {
			return false;
		}

		if (j < 0 || j >= n) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Problem200_NumberOfIslands obj = new Problem200_NumberOfIslands();

		char[][] grid = new char[][]{
			{'0', '1', '0'},
			{'1', '0', '1'},
			{'0', '1', '0'},
		};
		System.out.println(obj.numIslands(grid));

		grid = new char[][]{
			{'1', '1', '0', '0', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '1', '0', '0'},
			{'0', '0', '0', '1', '1'}
		};
		System.out.println(obj.numIslands(grid));
	}
}
