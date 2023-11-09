package leetcode;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */
public class Problem0081_SearchInRotatedSortedArray {
	public boolean search(int[] nums, int target) {
		int left = 0, right = nums.length-1;

		while (left <= right) {
			int mid = left + (right-left)/2;

			if (nums[left] == target
				|| nums[right] == target
				|| nums[mid] == target) {
				return true;
			}

			if (nums[mid] > nums[0]) {
				// num[left..mid] is no-decreasing sorted
				if (target > nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[mid] < nums[0]) {
				// num[mid..right] is non-decreasing sorted
				if (target > nums[mid] && target < nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				left++;
				right--;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		Problem0081_SearchInRotatedSortedArray obj = new Problem0081_SearchInRotatedSortedArray();
		System.out.println(obj.search(new int[] {2,5,6,0,0,1,2}, 0));
		System.out.println(obj.search(new int[] {2,5,6,0,0,1,2}, 3));
	}
}
