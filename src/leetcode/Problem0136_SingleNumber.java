package leetcode;

/**
 * https://leetcode-cn.com/problems/single-number/
 */
public class Problem0136_SingleNumber {
	public int singleNumber(int[] nums) {
		int ret = 0;

		for (int num : nums) {
			ret ^= num;
		}

		return ret;
	}
}

