package leetcode.dfs;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class Problem695_MaxAreaOfIsland {
	int[] dx = new int[] {0, -1, 0, 1};
	int[] dy = new int[] {1, 0, -1, 0};

	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		boolean[][] visited = new boolean[m][n];

		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1
					&& visited[i][j] == false) {
					maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
				}
			}
		}

		return maxArea;
	}

	private int dfs(int[][] grid, int curRow, int curCol, boolean[][] visited) {
		if (grid[curRow][curCol] == 0
			|| visited[curRow][curCol] == true) {
			return 0;
		}

		int area = 1;
		visited[curRow][curCol] = true;
		for (int i = 0; i < 4; i++) {
			int nextRow = curRow + dx[i];
			int nextCol = curCol + dy[i];
			if (nextRow >= 0 && nextRow < grid.length
				&& nextCol >= 0 && nextCol < grid[0].length) {
				area += dfs(grid, nextRow, nextCol, visited);
			}
		}

		return area;
	}

	public static void main(String[] args) {
		Problem695_MaxAreaOfIsland obj = new Problem695_MaxAreaOfIsland();
		System.out.println(obj.maxAreaOfIsland(new int[][] {
			{0,0,1,0,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,1,1,0,0,1,0,1,0,0},
			{0,1,0,0,1,1,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,1,1,0,0,0,0}
		}));

		System.out.println(obj.maxAreaOfIsland(new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0}}));
	}
}
