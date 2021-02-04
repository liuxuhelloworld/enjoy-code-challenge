package leetcode.sum;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class Problem16_ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
		if (len == 0) {
			throw new RuntimeException("bad input");
		}

		Arrays.sort(nums);

		int ret = 0;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int j = i+1, k = len-1;
			while (j < k) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					j++;
					continue;
				}

				int curSum = nums[i] + nums[j] + nums[k];

				int curDiff = Math.abs(curSum - target);
				if (curDiff < minDiff) {
					ret = curSum;
					minDiff = curDiff;
				}

				if (curSum > target) {
					k--;
				} else if (curSum < target) {
					j++;
				} else {
					return curSum;
				}
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem16_ThreeSumClosest obj = new Problem16_ThreeSumClosest();
		System.out.println(obj.threeSumClosest(new int[] {1, 1, 1, 1}, 4));
		System.out.println(obj.threeSumClosest(new int[] {1, 1, -1, -1, 3}, 3));
		System.out.println(obj.threeSumClosest(new int[] {-1, 2, 1, -4}, -4));
		System.out.println(obj.threeSumClosest(new int[] {-1, 2, 1, -4}, -3));
		System.out.println(obj.threeSumClosest(new int[] {-1, 2, 1, -4}, -2));
		System.out.println(obj.threeSumClosest(new int[] {-1, 2, 1, -4}, -1));
		System.out.println(obj.threeSumClosest(new int[] {-1, 2, 1, -4}, 0));
		System.out.println(obj.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
		System.out.println(obj.threeSumClosest(new int[] {-1, 2, 1, -4}, 2));
		System.out.println(obj.threeSumClosest(new int[] {-1, 2, 1, -4}, 3));
		System.out.println(obj.threeSumClosest(new int[] {-1, 2, 1, -4}, 4));
	}
}
