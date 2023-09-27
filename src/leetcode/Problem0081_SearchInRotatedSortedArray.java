package leetcode;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */
public class Problem0081_SearchInRotatedSortedArray {
	public boolean search(int[] nums, int target) {
		int len = nums.length;
		assert len > 0;

		int left = 0, right = nums.length-1;

		while (left <= right) {
			int mid = left + (right-left)/2;

			if (nums[mid] == target) {
				return true;
			}

			if (nums[mid] > nums[0]) {
				// num[0..mid] is sorted
				if (target >= nums[0] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[mid] < nums[0]) {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				for (int i = left; i <= right; i++) {
					if (nums[i] == target) {
						return true;
					}
				}
				break;
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
