package leetcode;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Problem0153_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else if (nums[mid] < nums[right]) {
				right = mid;
			}
		}

		return nums[left];
	}

	public static void main(String[] args) {
		Problem0153_FindMinimumInRotatedSortedArray obj = new Problem0153_FindMinimumInRotatedSortedArray();
		int mix = obj.findMin(new int[] {3,1,2});
		mix = obj.findMin(new int[] {0,1,2,4,5,6,7});
		mix = obj.findMin(new int[] {3,4,5,1,2});
		mix = obj.findMin(new int[] {11,13,15,17});
	}
}
