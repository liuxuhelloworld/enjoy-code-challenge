package leetcode.twopointers;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class Problem209_MinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
		int len = nums.length;

		int min = len;
		boolean flag = false;

		for (int left = 0; left < len; left++) {
			int sum = 0;
			for (int right = left; right < len && right < left + min; right++) {
				sum += nums[right];
				if (sum >= target) {
					if (right - left + 1 <= min) {
						min = right - left + 1;
						flag = true;
						break;
					}
				}
			}

			if (!flag) {
				break;
			}
		}

		return flag ? min : 0;
	}

	public static void main(String[] args) {
		Problem209_MinimumSizeSubarraySum obj = new Problem209_MinimumSizeSubarraySum();
		System.out.println(obj.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
		System.out.println(obj.minSubArrayLen(4, new int[] {1, 4, 4}));
		System.out.println(obj.minSubArrayLen(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}));
	}
}
