package leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class Problem0031_NextPermutation {
	public void nextPermutation(int[] nums) {

		int theStartIndexOfTheLastDescendingSubArray = getTheStartIndexOfTheLastDescendingSubArray(nums);

		if (theStartIndexOfTheLastDescendingSubArray == 0) {
			reverse(nums, 0, nums.length-1);
		} else {
			int theSwapIndexInTheDescendingSubArray = getTheSwapIndexInTheDescendingSubArray(
					nums, theStartIndexOfTheLastDescendingSubArray, nums[theStartIndexOfTheLastDescendingSubArray-1]);
			if (theSwapIndexInTheDescendingSubArray == -1) {
				throw new RuntimeException("error");
			}

			swap(nums, theStartIndexOfTheLastDescendingSubArray-1, theSwapIndexInTheDescendingSubArray);

			reverse(nums, theStartIndexOfTheLastDescendingSubArray, nums.length-1);
		}

		System.out.println(Arrays.toString(nums));
	}

	private int getTheStartIndexOfTheLastDescendingSubArray(int[] nums) {
		int len = nums.length;

		int i = len-1;
		while (i >= 1) {
			if (nums[i-1] < nums[i]) {
				break;
			}
			i--;
		}

		return i;
	}

	private int getTheSwapIndexInTheDescendingSubArray(int[] nums, int startIndex, int targetVal) {
		int len = nums.length;

		for (int i = len-1; i >= startIndex; i--) {
			if (nums[i] > targetVal) {
				return i;
			}
		}

		return -1;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private void reverse(int[] nums, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}

	public static void main(String[] args) {
		Problem0031_NextPermutation obj = new Problem0031_NextPermutation();
		obj.nextPermutation(new int[] {1, 2, 3});
		obj.nextPermutation(new int[] {3, 2, 1});
		obj.nextPermutation(new int[] {1, 1, 5});
		obj.nextPermutation(new int[] {1});
	}
}
