package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/check-knight-tour-configuration/
 */
public class Problem2596_CheckKnightTourConfiguration {
	public boolean checkValidGrid(int[][] grid) {
		int n = grid.length;

		int i = 0, j = 0;
		if (grid[i][j] != 0) {
			return false;
		}

		for (int target = 1; target < n*n; target++) {
			List<int[]> nextPosList = nextPosList(i, j, n);
			if (nextPosList.isEmpty()) {
				return false;
			}

			int[] validNexPos = validNextPos(nextPosList, grid, target);
			if (validNexPos == null) {
				return false;
			}

			i = validNexPos[0];
			j = validNexPos[1];
		}

		return true;
	}

	private List<int[]> nextPosList(int i, int j, int n) {
		List<int[]> list = new ArrayList<>();

		int nextI = i + 2;
		int nextJ = j + 1;
		if (validPos(nextI, nextJ, n)) {
			list.add(new int[] {nextI, nextJ});
		}
		nextJ = j - 1;
		if (validPos(nextI, nextJ, n)) {
			list.add(new int[] {nextI, nextJ});
		}

		nextI = i + 1;
		nextJ = j + 2;
		if (validPos(nextI, nextJ, n)) {
			list.add(new int[] {nextI, nextJ});
		}
		nextJ = j - 2;
		if (validPos(nextI, nextJ, n)) {
			list.add(new int[] {nextI, nextJ});
		}

		nextI = i - 1;
		nextJ = j + 2;
		if (validPos(nextI, nextJ, n)) {
			list.add(new int[] {nextI, nextJ});
		}
		nextJ = j - 2;
		if (validPos(nextI, nextJ, n)) {
			list.add(new int[] {nextI, nextJ});
		}

		nextI = i - 2;
		nextJ = j + 1;
		if (validPos(nextI, nextJ, n)) {
			list.add(new int[] {nextI, nextJ});
		}
		nextJ = j - 1;
		if (validPos(nextI, nextJ, n)) {
			list.add(new int[] {nextI, nextJ});
		}

		return list;
	}

	private boolean validPos(int i, int j, int n) {
		if (i < 0 || i >= n) {
			return false;
		}
		if (j < 0 || j >= n) {
			return false;
		}
		return true;
	}

	private int[] validNextPos(List<int[]> nextPosList, int[][] grid, int target) {
		for (int[] nextPos : nextPosList) {
			int i = nextPos[0];
			int j = nextPos[1];

			if (grid[i][j] == target) {
				return nextPos;
			}
		}

		return null;
	}

	public static void main(String[] args) {
		Problem2596_CheckKnightTourConfiguration obj = new Problem2596_CheckKnightTourConfiguration();
		int[][] grid = new int[][] {
			{8, 3, 6},
			{5, 0, 1},
			{2, 7, 4}};

		System.out.println(obj.checkValidGrid(grid));
	}
}
