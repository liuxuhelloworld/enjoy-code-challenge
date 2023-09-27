package leetcode;

/**
 * https://leetcode.cn/problems/minimum-cuts-to-divide-a-circle/
 */
public class Problem2481_MinimumCutsToDivideCircle {
	public int numberOfCuts(int n) {
		if (n == 1) {
			return 0;
		}

		if (n % 2 == 0) {
			return n / 2;
		} else {
			return n;
		}
	}
}
