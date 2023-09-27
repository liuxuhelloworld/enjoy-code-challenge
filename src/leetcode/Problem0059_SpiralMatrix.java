package leetcode;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class Problem0059_SpiralMatrix {
	enum Direction {RIGHT, DOWN, LEFT, UP};

	public int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		boolean[][] tag = new boolean[n][n];

		Position last = new Position(0, -2);
		Position cur = new Position(0, -1);
		int val = 1;
		do {
			Direction direction = computeDirection(last, cur);
			Position next = getNextPosition(cur, direction, n, n, tag);
			if (next == null) {
				break;
			}

			ret[next.row][next.col] = val++;
			tag[next.row][next.col] = true;
			last = cur;
			cur = next;
		} while (true);

		return ret;
	}

	private static class Position {
		int row, col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	private Direction computeDirection(Position last, Position cur) {
		int curRow = cur.row, curCol = cur.col;
		int lastRow = last.row, lastCol = last.col;

		if (curRow == lastRow) {
			if (curCol > lastCol) {
				return Direction.RIGHT;
			} else {
				return Direction.LEFT;
			}
		} else {
			if (curRow > lastRow) {
				return Direction.DOWN;
			} else {
				return Direction.UP;
			}
		}
	}

	private Position getNextPosition(Position cur, Direction direction, int m, int n, boolean[][] tag) {
		Position next = getNextPositionByDirection(cur, direction);
		if (isValidPosition(next, m, n, tag)) {
			return next;
		} else {
			next = turnRightPosition(cur, direction);
			if (isValidPosition(next, m, n, tag)) {
				return next;
			}
		}

		return null;
	}

	private Position getNextPositionByDirection(Position cur, Direction direction) {
		int curRow = cur.row, curCol = cur.col;
		int nextRow, nextCol;

		if (direction.equals(Direction.RIGHT)) {
			nextRow = curRow;
			nextCol = curCol + 1;
		} else if (direction.equals(Direction.DOWN)) {
			nextRow = curRow + 1;
			nextCol = curCol;
		} else if (direction.equals(Direction.LEFT)) {
			nextRow = curRow;
			nextCol = curCol - 1;
		} else {
			nextRow = curRow - 1;
			nextCol = curCol;
		}

		return new Position(nextRow, nextCol);
	}

	private boolean isValidPosition(Position pos, int m, int n, boolean[][] tag) {
		if (pos.row < 0 || pos.row >= m) {
			return false;
		}

		if (pos.col < 0 || pos.col >= n) {
			return false;
		}

		return tag[pos.row][pos.col] == false;
	}

	private Position turnRightPosition(Position cur, Direction direction) {
		int curRow = cur.row, curCol = cur.col;
		int nextRow, nextCol;

		if (direction.equals(Direction.RIGHT)) {
			nextRow = curRow + 1;
			nextCol = curCol;
		} else if (direction.equals(Direction.DOWN)) {
			nextRow = curRow;
			nextCol = curCol - 1;
		} else if (direction.equals(Direction.LEFT)) {
			nextRow = curRow - 1;
			nextCol = curCol;
		} else {
			nextRow = curRow;
			nextCol = curCol + 1;
		}

		return new Position(nextRow, nextCol);
	}

	public static void main(String[] args) {
		Problem0059_SpiralMatrix obj = new Problem0059_SpiralMatrix();
		System.out.println(obj.generateMatrix(1));
		System.out.println(obj.generateMatrix(3));
	}
}
