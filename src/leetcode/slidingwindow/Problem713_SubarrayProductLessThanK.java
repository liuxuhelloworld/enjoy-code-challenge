package leetcode.slidingwindow;

/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class Problem713_SubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}

		int cnt = 0;

		int left = 0, right = 0, product = 1;
		while (right < nums.length) {
			product *= nums[right];

			while (product >= k) {
				product /= nums[left];
				left++;
			}

			cnt += right - left + 1;

			right++;
		}

		return cnt;
	}

	public static void main(String[] args) {
		Problem713_SubarrayProductLessThanK obj = new Problem713_SubarrayProductLessThanK();
		System.out.println(obj.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
		System.out.println(obj.numSubarrayProductLessThanK(new int[] {1, 2, 3}, 0));
	}
}
