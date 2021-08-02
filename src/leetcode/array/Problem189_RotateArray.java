package leetcode.array;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class Problem189_RotateArray {
	public void rotate(int[] nums, int k) {
		assert nums.length > 0;
		assert k >= 0;

		int len = nums.length;

		k = k % len;
		if (k == 0) {
			return;
		}

		int[] tmp = new int[k];
		for (int i = 0; i < k; i++) {
			tmp[i] = nums[len - k + i];
		}

		for (int i = len - k - 1; i >= 0; i--) {
			nums[i + k] = nums[i];
		}

		for (int i = 0; i < k; i++) {
			nums[i] = tmp[i];
		}
	}

	public static void main(String[] args) {
		Problem189_RotateArray obj = new Problem189_RotateArray();
		obj.rotate(new int[] {1,2,3,4,5,6,7}, 3);
	}
}
