package leetcode;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class Problem0977_SquaresOfSortedArray {
	public int[] sortedSquares(int[] nums) {
		assert nums.length > 0;

		int len = nums.length;

		int[] squares = new int[len];

		int i = 0, j = len - 1, k = len - 1;
		while (i <= j) {
			if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
				squares[k--] = nums[i] * nums[i];
				i++;
			} else {
				squares[k--] = nums[j] * nums[j];
				j--;
			}
		}

		return squares;
	}

	public static void main(String[] args) {
		Problem0977_SquaresOfSortedArray obj = new Problem0977_SquaresOfSortedArray();
		System.out.println(obj.sortedSquares(new int[] {-4,-1,0,3,10}));
		System.out.println(obj.sortedSquares(new int[] {-7,-3,2,3,11}));
	}
}
