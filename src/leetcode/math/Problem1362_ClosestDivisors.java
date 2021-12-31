package leetcode.math;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/closest-divisors/
 */
public class Problem1362_ClosestDivisors {
	public int[] closestDivisors(int num) {
		int target1 = num + 1;
		int target2 = num + 2;

		int[] divisors1 = minDiffDivisors(target1);
		int[] divisors2 = minDiffDivisors(target2);

		if (Math.abs(divisors1[0] - divisors1[1]) < Math.abs(divisors2[0] - divisors2[1])) {
			return divisors1;
		} else {
			return divisors2;
		}
	}

	private int[] minDiffDivisors(int num) {
		int max = (int) Math.floor(Math.sqrt(num));

		int minDiff = Integer.MAX_VALUE;
		int[] ret = new int[2];
		for (int i = 1; i <= max; i++) {
			if (num % i == 0) {
				int j = num / i;
				int curDiff = Math.abs(i - j);
				if (curDiff < minDiff) {
					minDiff = curDiff;
					ret[0] = i;
					ret[1] = j;
				}
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem1362_ClosestDivisors obj = new Problem1362_ClosestDivisors();
		System.out.println(Arrays.toString(obj.closestDivisors(8)));
		System.out.println(Arrays.toString(obj.closestDivisors(123)));
		System.out.println(Arrays.toString(obj.closestDivisors(999)));
	}
}
