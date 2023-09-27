package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class Problem0695_MaxAreaOfIsland {
	int[] dx = new int[] {0, -1, 0, 1};
	int[] dy = new int[] {1, 0, -1, 0};

	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;

		int m = grid.length;
		int n = grid[0].length;

		Queue<int[]> queue = new LinkedList<>();

		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && visited[i][j] == false) {
					queue.clear();

					queue.add(new int[] {i, j});
					visited[i][j] = true;
					int area = 1;
					while (!queue.isEmpty()) {
						int[] cur = queue.poll();
						for (int k = 0; k < 4; k++) {
							int nextRow = cur[0] + dx[k];
							int nextCol = cur[1] + dy[k];
							if (nextRow >= 0 && nextRow < m
								&& nextCol >= 0 && nextCol < n
								&& grid[nextRow][nextCol] == 1
								&& visited[nextRow][nextCol] == false) {
								queue.add(new int[] {nextRow, nextCol});
								visited[nextRow][nextCol] = true;
								area++;
							}
						}
					}

					if (area > maxArea) {
						maxArea = area;
					}
				}
			}
		}

		return maxArea;
	}

	public int maxAreaOfIsland2(int[][] grid) {
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
		Problem0695_MaxAreaOfIsland obj = new Problem0695_MaxAreaOfIsland();
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
