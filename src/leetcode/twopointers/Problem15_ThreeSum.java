package leetcode.twopointers;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum/
 */
public class Problem15_ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return Collections.emptyList();
		}

		Arrays.sort(nums);

		List<List<Integer>> ret = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}

			int target = 0 - nums[i];
			int j = i + 1, k = len - 1;
			while (j < k) {
				if (j > i+1 && nums[j] == nums[j-1]) {
					j++;
					continue;
				}

				int curSum = nums[j] + nums[k];
				if (curSum > target) {
					k--;
				} else if (curSum < target) {
					j++;
				} else {
					ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				}
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem15_ThreeSum obj = new Problem15_ThreeSum();
		System.out.println(obj.threeSum(new int[] {0, 0, 0, 0, 0, 0}));
		System.out.println(obj.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
		System.out.println(obj.threeSum(new int[] {}));
		System.out.println(obj.threeSum(new int[] {0}));
	}
}
