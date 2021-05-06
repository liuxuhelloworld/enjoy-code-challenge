package leetcode;

/**
 * https://leetcode-cn.com/problems/word-search/
 */
public class Problem79_WordSearch {
	enum Direction {LEFT, UP, RIGHT, DOWN};

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;


		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean[][] tag = new boolean[m][n];
				tag[i][j] = true;
				boolean exists = dfs(board, word, i, j, 0, tag);
				if (exists) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, String word, int curRow, int curCol, int curIdx, boolean[][] tag) {
		if (board[curRow][curCol] != word.charAt(curIdx)) {
			return false;
		}

		if (curIdx == word.length()-1) {
			return true;
		}

		int nextRow, nextCol;

		for (Direction direction : Direction.values()) {
			nextRow = getNextRow(curRow, direction);
			nextCol = getNextCol(curCol, direction);
			if (isValidNextCell(nextRow, nextCol, word.charAt(curIdx+1), board, tag)) {
				tag[nextRow][nextCol] = true;
				boolean exists = dfs(board, word, nextRow, nextCol, curIdx+1, tag);
				if (exists) {
					return true;
				} else {
					tag[nextRow][nextCol] = false;
				}
			}
		}

		return false;
	}

	private int getNextRow(int row, Direction direction) {
		switch (direction) {
			case LEFT:
			case RIGHT:
				return row;
			case UP:
				return row - 1;
			case DOWN:
				return row + 1;
			default:
				throw new RuntimeException("bad input");
		}
	}

	private int getNextCol(int col, Direction direction) {
		switch (direction) {
			case LEFT:
				return col - 1;
			case RIGHT:
				return col + 1;
			case UP:
			case DOWN:
				return col;
			default:
				throw new RuntimeException("bad input");
		}
	}

	private boolean isValidNextCell(int nextRow, int nextCol, char nextCh, char[][] board, boolean[][] tag) {
		return isValidRow(nextRow, board.length)
			&& isValidCol(nextCol, board[0].length)
			&& tag[nextRow][nextCol] == false
			&& nextCh == board[nextRow][nextCol];
	}

	private boolean isValidRow(int row, int rowsNum) {
		return row >= 0 && row < rowsNum;
	}

	private boolean isValidCol(int col, int colsNum) {
		return col >= 0 && col < colsNum;
	}

	public static void main(String[] args) {
		Problem79_WordSearch obj = new Problem79_WordSearch();
		System.out.println(obj.exist(
			new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
			"ABCCED"));
		System.out.println(obj.exist(
			new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
			"SEE"));
		System.out.println(obj.exist(
			new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
			"ABCB"));

	}
}
