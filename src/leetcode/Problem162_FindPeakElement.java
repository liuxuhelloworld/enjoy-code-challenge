package leetcode;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 */
public class Problem162_FindPeakElement {
	public int findPeakElement(int[] nums) {
		int len = nums.length;
		if (len == 1) {
			return 0;
		}

		int left = 0, right = len - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (isPeak(nums, mid)) {
				return mid;
			} else if (nums[mid] < nums[mid+1]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1; // logically unreachable statement
	}

	private boolean isPeak(int[] nums, int i) {
		int len = nums.length;
		if (len == 1) {
			return true;
		}

		if (i == 0) {
			return nums[i] > nums[i+1];
		}

		if (i == len - 1) {
			return nums[i] > nums[i-1];
		}

		return nums[i] > nums[i-1] && nums[i] > nums[i+1];
	}

	public static void main(String[] args) {
		Problem162_FindPeakElement obj = new Problem162_FindPeakElement();
		System.out.println(obj.findPeakElement(new int[] {1,2,3,1}));
		System.out.println(obj.findPeakElement(new int[] {1,2,1,3,5,6,4}));
	}
}
