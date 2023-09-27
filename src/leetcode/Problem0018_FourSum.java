package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 */
public class Problem0018_FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		int len = nums.length;
		if (len < 4) {
			return Collections.emptyList();
		}

		List<List<Integer>> ret = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			for (int j = i+1; j < len; j++) {
				if (j > i+1 && nums[j] == nums[j-1]) {
					continue;
				}
				int sum = nums[i] + nums[j];
				if (sum > target && nums[j] > 0) {
					break;
				} else {
					int diff = target - sum;
					int m = j+1, n = len-1;
					while (m < n) {
						if (m > j+1 && nums[m] == nums[m-1]) {
							m++;
							continue;
						}
						int curSum = nums[m] + nums[n];
						if (curSum < diff) {
							m++;
						} else if (curSum > diff) {
							n--;
						} else {
							ret.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
							m++;
							n--;
						}
					}
				}
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem0018_FourSum obj = new Problem0018_FourSum();
		System.out.println(obj.fourSum(new int[] {1, -2, -5, -4, -3, 3, 3, 5}, -11));
		System.out.println(obj.fourSum(new int[] {-1, 0, 1, 2, -1, -4}, -1));
		System.out.println(obj.fourSum(new int[] {-3, -1, 0, 2, 4, 5}, 2));
		System.out.println(obj.fourSum(new int[] {-3, -1, 0, 2, 4, 5}, 0));
		System.out.println(obj.fourSum(new int[] {}, 0));
		System.out.println(obj.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
	}
}
