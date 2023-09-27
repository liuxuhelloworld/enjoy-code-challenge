package leetcode;

/**
 * https://leetcode.cn/problems/ways-to-make-a-fair-array/
 */
public class Problem1664_WaysToMakeFairArray {
	public int waysToMakeFair(int[] nums) {
		int cnt = 0;

		int leftOddSum = 0, leftEvenSum = 0;
		int rightOddSum = 0, rightEvenSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				rightEvenSum += nums[i];
			} else {
				rightOddSum += nums[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			boolean curIdxEven = i % 2 == 0;

			if (curIdxEven) {
				rightEvenSum -= nums[i];
			} else {
				rightOddSum -= nums[i];
			}

			if (leftEvenSum + rightOddSum == leftOddSum + rightEvenSum) {
				cnt++;
			}

			if (curIdxEven) {
				leftEvenSum += nums[i];
			} else {
				leftOddSum += nums[i];
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		Problem1664_WaysToMakeFairArray obj = new Problem1664_WaysToMakeFairArray();
		System.out.println(obj.waysToMakeFair(new int[] {4,1,1,2,5,1,5,4}));
	}
}
