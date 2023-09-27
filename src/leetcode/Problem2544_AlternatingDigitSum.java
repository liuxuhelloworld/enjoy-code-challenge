package leetcode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/alternating-digit-sum/
 */
public class Problem2544_AlternatingDigitSum {
	public int alternateDigitSum(int n) {
		Stack<Integer> stack = new Stack<>();
		while (n != 0) {
			int remian = n % 10;
			stack.push(remian);
			n = n / 10;
		}

		int sign = 1;
		int sum = 0;
		while (!stack.isEmpty()) {
			int val = stack.pop();
			sum += sign * val;
			sign *= -1;
		}

		return sum;
	}
}
