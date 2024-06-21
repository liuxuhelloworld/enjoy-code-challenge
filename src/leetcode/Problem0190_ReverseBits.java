package leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class Problem0190_ReverseBits {
	private int[] mapping = {0b0000, 0b1000, 0b0100, 0b1100, 0b0010, 0b1010, 0b0110, 0b1110,
							 0b0001, 0b1001, 0b0101, 0b1101, 0b0011, 0b1011, 0b0111, 0b1111};

	public int reverseBits(int n) {
		int ret = 0;

		for (int i = 0; i < 8; i++) {
			int rightest4Bits = n & 15;
			n = n >> 4;
			ret = ret << 4;
			ret = ret | mapping[rightest4Bits];
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem0190_ReverseBits obj = new Problem0190_ReverseBits();
		System.out.println(obj.reverseBits(0b00000010100101000001111010011100));
		System.out.println(obj.reverseBits(0b11111111111111111111111111111101));
	}
}
