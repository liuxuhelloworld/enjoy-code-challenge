package leetcode;

/**
 * https://leetcode-cn.com/problems/binary-search/
 */
public class Problem0704_BinarySearch {
	public int search(int[] nums, int target) {
		assert nums.length > 0;

		int left = 0, right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return -1;
	}
}
