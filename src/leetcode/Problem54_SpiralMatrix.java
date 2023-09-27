package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Problem54_SpiralMatrix {
	enum Direction {RIGHT, DOWN, LEFT, UP};

	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		boolean[][] tag = new boolean[m][n];

		List<Integer> ret = new ArrayList<>();

		Position last = new Position(0, -2);
		Position cur = new Position(0, -1);
		do {
			Direction direction = computeDirection(last, cur);
			Position next = getNextPosition(cur, direction, m, n, tag);
			if (next == null) {
				break;
			}

			ret.add(matrix[next.row][next.col]);
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
		Problem54_SpiralMatrix obj = new Problem54_SpiralMatrix();
		System.out.println(obj.spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
		System.out.println(obj.spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
	}
}
