package leetcode;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class Problem0189_RotateArray {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		if (len == 0) {
			return;
		}

		k = k % len;
		if (k == 0) {
			return;
		}

		// reverse left len-k elements
		reverse(nums, 0, len - k - 1);

		// reverse right k elements
		reverse(nums, len - k, len - 1);

		// reverse all elements
		reverse(nums, 0, len - 1);
	}

	private void reverse(int[] nums, int left, int right) {
		for (int i = left, j = right; i < j; i++, j--) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}

	public static void main(String[] args) {
		Problem0189_RotateArray obj = new Problem0189_RotateArray();
		obj.rotate(new int[] {1,2,3,4,5,6,7}, 3);
	}
}
