package leetcode;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Problem29_DivideTwoIntegers {
	/**
	 * exceed time limit
	 */
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		int addUnit = 1;
		if ((dividend > 0 && divisor < 0)
			|| (dividend < 0 && divisor > 0)) {
			addUnit = -1;
		}

		long longDividend = Math.abs((long)dividend);
		long longDivisor = Math.abs((long)divisor);

		long res = 0;
		while (longDividend >= longDivisor) {
			longDividend -= longDivisor;
			res += addUnit;
		}

		if (res > Integer.MAX_VALUE
			|| res < Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}

		return (int)res;
	}

	public int divideV2(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		boolean negative = false;
		if ((dividend > 0 && divisor < 0)
			|| (dividend < 0 && divisor > 0)) {
			negative = true;
		}

		long res = 0;

		long curDividend = Math.abs((long)dividend);
		long longDivisor = Math.abs((long)divisor);
		while (longDivisor <= curDividend) {
			long twoPowerNumberDivisors = 1;
			long twoPowerNumberDivisorsSum = longDivisor;
			while (twoPowerNumberDivisorsSum + twoPowerNumberDivisorsSum < curDividend) {
				twoPowerNumberDivisorsSum += twoPowerNumberDivisorsSum;
				twoPowerNumberDivisors += twoPowerNumberDivisors;
			}
			res += twoPowerNumberDivisors;
			curDividend -= twoPowerNumberDivisorsSum;
		}

		if (negative) {
			res = 0 - res;
		}

		if (res > Integer.MAX_VALUE
			|| res < Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}

		return (int)res;
	}

	public static void main(String[] args) {
		Problem29_DivideTwoIntegers obj = new Problem29_DivideTwoIntegers();
		System.out.println(obj.divideV2(-2147483648, -1));
		System.out.println(obj.divideV2(2147483647, 1));
		System.out.println(obj.divideV2(10, 3));
		System.out.println(obj.divideV2(7, -3));
		System.out.println(obj.divideV2(0, 1));
		System.out.println(obj.divideV2(1, 1));
	}
}
