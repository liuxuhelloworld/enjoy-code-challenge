package leetcode.bit;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class Problem191_NumberOf1Bits {
	public int hammingWeight(int n) {
		if (n == 0) {
			return 0;
		}

		int weight = 0;
		do {
			weight++;
		} while ((n = (n & n-1)) != 0);


		return weight;
	}

	public static void main(String[] args) {
		Problem191_NumberOf1Bits obj = new Problem191_NumberOf1Bits();
		System.out.println(obj.hammingWeight(11));
		System.out.println(obj.hammingWeight(128));
		System.out.println(obj.hammingWeight(-3));
	}
}
