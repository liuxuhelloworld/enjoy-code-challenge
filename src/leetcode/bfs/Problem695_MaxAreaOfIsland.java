package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class Problem695_MaxAreaOfIsland {
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
