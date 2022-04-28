package leetcode.backtracking;

/**
 * https://leetcode-cn.com/problems/word-search/
 */
public class Problem79_WordSearch {
	private int[] dx = new int[] {-1, 1, 0, 0};
	private int[] dy = new int[] {0, 0, -1, 1};

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;

		boolean[][] tag = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					resetTag(tag);
					tag[i][j] = true;
					boolean exists = backtrack(board, i, j, word, 0, tag);
					if (exists) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private void resetTag(boolean[][] tag) {
		for (int i = 0; i < tag.length; i++) {
			for (int j = 0; j < tag[0].length; j++) {
				if (tag[i][j]) {
					tag[i][j] = false;
				}
			}
		}
	}

	private boolean backtrack(char[][] board, int curRow, int curCol, String word, int curIdx, boolean[][] tag) {
		if (board[curRow][curCol] != word.charAt(curIdx)) {
			return false;
		}

		if (curIdx == word.length()-1) {
			return true;
		}

		for (int i = 0; i < dx.length; i++) {
			int nextRow = curRow + dx[i];
			int nextCol = curCol + dy[i];
			if (isValidNextCell(nextRow, nextCol, word.charAt(curIdx+1), board, tag)) {
				tag[nextRow][nextCol] = true;
				boolean exists = backtrack(board, nextRow, nextCol, word,curIdx+1, tag);
				if (exists) {
					return true;
				}
				tag[nextRow][nextCol] = false;
			}
		}

		return false;
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
			new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}},
			"ABCESEEEFS"));
		System.out.println(obj.exist(
			new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
			"SEE"));
		System.out.println(obj.exist(
			new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
			"ABCB"));
	}
}
