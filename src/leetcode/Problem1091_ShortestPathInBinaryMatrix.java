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

		int path = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean flag = false;
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int row = cur[0], col = cur[1];
				if (row == n-1 && col == n-1) {
					return path;
				}

				for (int k = 0; k < dx.length; k++) {
					int newRow = row + dx[k];
					int newCol = col + dy[k];

					if (isValid(newRow, newCol, n)
						&& grid[newRow][newCol] == 0
						&& !visited[newRow][newCol]) {
						flag = true;
						queue.add(new int[] {newRow, newCol});
						visited[newRow][newCol] = true;
					}
				}
			}

			if (flag) {
				path++;
			}
		}

		return -1;
	}

	private boolean isValid(int row, int col, int n) {
		if (row < 0 || row >= n) {
			return false;
		}

		if (col < 0 || col >= n) {
			return false;
		}

		return true;
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
