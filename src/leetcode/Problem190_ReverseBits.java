package leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class Problem190_ReverseBits {
	public int reverseBits(int n) {
		int ret = 0;

		for (int i = 0; i < 32; i++) {
			int rightest = n & 1;
			n = n >> 1;
			ret = ret << 1;
			ret = ret | rightest;
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem190_ReverseBits obj = new Problem190_ReverseBits();
		System.out.println(obj.reverseBits(43261596));
		System.out.println(obj.reverseBits(-3));
	}
}
