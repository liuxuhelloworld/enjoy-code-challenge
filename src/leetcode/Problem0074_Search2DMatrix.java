package leetcode;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class Problem0074_Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = binarySearch(matrix, target);
		if (row == -1) {
			return false;
		}

		return binarySearch(matrix[row], target);
	}

	private int binarySearch(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int top = 0, down = m-1;
		while (top <= down) {
			int mid = top + (down-top)/2;
			if (target >= matrix[mid][0] && target <= matrix[mid][n-1]) {
				return mid;
			} else if (target < matrix[mid][0]) {
				down = mid - 1;
			} else if (target > matrix[mid][n-1]) {
				top = mid + 1;
			}
		}

		return -1;
	}

	private boolean binarySearch(int[] row, int target) {
		int left = 0, right = row.length-1;
		while (left <= right) {
			int mid = left + (right-left)/2;
			if (target == row[mid]) {
				return true;
			} else if (target < row[mid]){
				right = mid - 1;
			} else if (target > row[mid]) {
				left = mid + 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Problem0074_Search2DMatrix obj = new Problem0074_Search2DMatrix();
		System.out.println(obj.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
		System.out.println(obj.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
	}
}
