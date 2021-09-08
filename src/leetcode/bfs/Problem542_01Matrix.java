package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/01-matrix/
 */
public class Problem542_01Matrix {
	int[] dx = new int[] {0, -1, 0, 1};
	int[] dy = new int[] {1, 0, -1, 0};

	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					queue.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curRow = cur[0], curCol = cur[1];
			for (int i = 0; i < 4; i++) {
				int newRow = curRow + dx[i];
				int newCol = curCol + dy[i];
				if (newRow >= 0 && newRow < m
					&& newCol >= 0 && newCol < n
					&& !visited[newRow][newCol]) {
					mat[newRow][newCol] = mat[curRow][curCol] + 1;
					visited[newRow][newCol] = true;
					queue.add(new int[] {newRow, newCol});
				}
			}
		}

		return mat;
	}

	public static void main(String[] args) {
		Problem542_01Matrix obj = new Problem542_01Matrix();
		int[][] mat = new int[][] {
			{0, 0, 0},
			{0, 1, 0},
			{0, 0, 0}
		};
		int[][] distance = obj.updateMatrix(mat);
		System.out.println(distance);

		mat = new int[][] {
			{0, 0, 0},
			{0, 1, 0},
			{1, 1, 1}
		};
		distance = obj.updateMatrix(mat);
		System.out.println(distance);
	}
}
