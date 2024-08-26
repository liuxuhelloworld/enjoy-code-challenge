package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 */
public class Problem1091_ShortestPathInBinaryMatrix {
	private int[] dx = new int[] {-1, -1, -1, 0, 1, 1, 1, 0};
	private int[] dy = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};

	public int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;

		if (grid[0][0] != 0 || grid[n-1][n-1] != 0) {
			return -1;
		}

		boolean[][] visited = new boolean[n][n];

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {0, 0});
		visited[0][0] = true;
		int depth = 0;

		while (!queue.isEmpty()) {
			depth++;

			int size = queue.size();
			while (size-- > 0) {
				int[] cur = queue.poll();
				int row = cur[0], col = cur[1];

				if (row == n-1 && col == n-1) {
					return depth;
				}

				for (int k = 0; k < dx.length; k++) {
					int newRow = row + dx[k];
					int newCol = col + dy[k];

					if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
						continue;
					}

					if (grid[newRow][newCol] == 0
						&& !visited[newRow][newCol]) {
						queue.add(new int[] {newRow, newCol});
						visited[newRow][newCol] = true;
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Problem1091_ShortestPathInBinaryMatrix obj = new Problem1091_ShortestPathInBinaryMatrix();

		int[][] grid = new int[][] {
			{0, 1},
			{1, 0}
		};
		System.out.println(obj.shortestPathBinaryMatrix(grid));

		grid = new int[][] {
			{0, 0, 0},
			{1, 1, 0},
			{1, 1, 0}
		};
		System.out.println(obj.shortestPathBinaryMatrix(grid));

		grid = new int[][] {
			{0, 0, 0},
			{1, 1, 1},
			{1, 1, 0}
		};
		System.out.println(obj.shortestPathBinaryMatrix(grid));
	}
}
