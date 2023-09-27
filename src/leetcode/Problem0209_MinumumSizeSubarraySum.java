package leetcode;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class Problem0209_MinumumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
		int min = Integer.MAX_VALUE;
		int left = 0, right = 0;
		int sum = 0;

		while (right < nums.length) {
			sum += nums[right];

			while (sum >= target) {
				min = Math.min(min, right - left + 1);
				sum -= nums[left];
				left++;
			}

			right++;
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args) {
		Problem0209_MinumumSizeSubarraySum obj = new Problem0209_MinumumSizeSubarraySum();
		System.out.println(obj.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
		System.out.println(obj.minSubArrayLen(4, new int[] {1, 4, 4}));
		System.out.println(obj.minSubArrayLen(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}));
	}
}
