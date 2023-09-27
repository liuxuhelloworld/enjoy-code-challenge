package leetcode;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class Problem0048_RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

		for (int lowCol = 0, highCol = n-1; lowCol < highCol; lowCol++, highCol--) {
			for (int row = 0; row < n; row++) {
				int tmp = matrix[row][lowCol];
				matrix[row][lowCol] = matrix[row][highCol];
				matrix[row][highCol] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		Problem0048_RotateImage obj = new Problem0048_RotateImage();
		int[][] matrix = new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		obj.rotate(matrix);
		System.out.println(matrix.toString());
	}
}
