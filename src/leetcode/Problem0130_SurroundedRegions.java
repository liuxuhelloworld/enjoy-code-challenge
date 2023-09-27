package leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 */
public class Problem0130_SurroundedRegions {
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public void solve(char[][] board) {
		int rows = board.length;
		int cols = board[0].length;

		for (int j = 0; j < cols; j++) {
			if (board[0][j] == 'O') {
				dfs(board, 0, j);
			}
			if (board[rows-1][j] == 'O') {
				dfs(board, rows-1, j);
			}
		}

		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O') {
				dfs(board, i, 0);
			}
			if (board[i][cols-1] == 'O') {
				dfs(board, i, cols-1);
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'A') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void dfs(char[][] board, int i, int j) {
		board[i][j] = 'A';

		for (int k = 0; k < dx.length; k++) {
			int nextI = i + dx[k];
			int nextJ = j + dy[k];

			if (isValid(board, nextI, nextJ)
				&& board[nextI][nextJ] == 'O') {
				dfs(board, nextI, nextJ);
			}
		}
	}

	private boolean isValid(char[][] board, int i, int j) {
		int rows = board.length;
		int cols = board[0].length;

		if (i < 0 || i >= rows) {
			return false;
		}

		if (j < 0 || j >= cols) {
			return false;
		}

		return true;
	}
	
	public static void main(String[] args) {
		Problem0130_SurroundedRegions obj = new Problem0130_SurroundedRegions();

		char[][] board = new char[][] {
			{'X', 'X', 'X', 'X'},
			{'X', 'O', 'O', 'X'},
			{'X', 'X', 'O', 'X'},
			{'X', 'O', 'X', 'X'}
		};

		obj.solve(board);

		System.out.println(Arrays.toString(board));
	}
}
