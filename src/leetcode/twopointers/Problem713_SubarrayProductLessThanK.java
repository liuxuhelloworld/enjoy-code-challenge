package leetcode.twopointers;

/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class Problem713_SubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int cnt = 0;

		for (int start = 0; start < nums.length; start++) {
			int end = endIndexOfMaxSubarrayProductLessThanKStartFrom(nums, start, k);
			if (end >= start) {
				cnt += end - start + 1;
			}
		}

		return cnt;
	}

	private int endIndexOfMaxSubarrayProductLessThanKStartFrom(int[] nums, int start, int k) {
		int product = 1;
		int i = start;
		for (; i < nums.length; i++) {
			product *= nums[i];
			if (product >= k) {
				break;
			}
		}

		return i - 1;
	}

	public static void main(String[] args) {
		Problem713_SubarrayProductLessThanK obj = new Problem713_SubarrayProductLessThanK();
		System.out.println(obj.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
		System.out.println(obj.numSubarrayProductLessThanK(new int[] {1, 2, 3}, 0));
	}
}
