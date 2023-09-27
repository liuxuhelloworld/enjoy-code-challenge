package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class Problem0073_SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		assert matrix.length > 0;
		assert matrix[0].length > 0;

		int m = matrix.length;
		int n = matrix[0].length;

		Set<Integer> zeroRows = new HashSet<>();
		Set<Integer> zeroCols = new HashSet<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					zeroRows.add(i);
					zeroCols.add(j);
				}
			}
		}

		for (Integer row : zeroRows) {
			for (int j = 0; j < n; j++) {
				matrix[row][j] = 0;
			}
		}

		for (Integer col : zeroCols) {
			for (int i = 0; i < m; i++) {
				matrix[i][col] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Problem0073_SetMatrixZeroes obj = new Problem0073_SetMatrixZeroes();
		obj.setZeroes(new int[][] {{1,1,1},{1,0,1},{1,1,1}});
		obj.setZeroes(new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}});
	}
}
