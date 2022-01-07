package leetcode.array;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class Problem35_SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
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

		return right + 1;
	}

	public static void main(String[] args) {
		Problem35_SearchInsertPosition obj = new Problem35_SearchInsertPosition();
		System.out.println(obj.searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(obj.searchInsert(new int[] {1,3,5,6}, 2));
		System.out.println(obj.searchInsert(new int[] {1,3,5,6}, 7));
		System.out.println(obj.searchInsert(new int[] {1,3,5,6}, 0));
		System.out.println(obj.searchInsert(new int[] {1}, 0));

	}
}
