package leetcode;

/**
 * https://leetcode.cn/problems/reverse-integer/
 */
public class Problem0007_ReverseInteger {
	public int reverse(int x) {
		if (x == Integer.MIN_VALUE) {
			return 0;
		}

		int maxIntDivide10 = Integer.MAX_VALUE / 10;
		int maxIntDivide10Remain = Integer.MAX_VALUE % 10;

		boolean negative = x < 0;
		int absX = x >= 0 ? x : -x;

		int reverse = 0;
		while (absX > 0) {
			int remain = absX % 10;

			if (reverse > maxIntDivide10
				|| (reverse == maxIntDivide10 && remain > maxIntDivide10Remain)) {
				return 0;
			}

			reverse = reverse * 10 + remain;

			absX = absX / 10;
		}

		return negative ? -reverse : reverse;
	}

	public static void main(String[] args) {
		Problem0007_ReverseInteger obj = new Problem0007_ReverseInteger();
		System.out.println(obj.reverse(1534236469));
	}
}
