package leetcode.math;

public class Problem1015_SmallestIntegerDivisibleByK {
	public int smallestRepunitDivByK(int k) {
		if (k == 1) {
			return 1;
		}

		if (k % 2 == 0) {
			return -1;
		}

		if (k % 5 == 0) {
			return -1;
		}

		int cnt = 1;
		int val = 1;
		while (true) {
			val = val*10 + 1;
			cnt++;

			int remainder = val % k;
			if (remainder % k == 0) {
				return cnt;
			}

			if (remainder == 1) {
				break;
			}

			val = remainder;
		}

		return -1;
	}

	public static void main(String[] args) {
		Problem1015_SmallestIntegerDivisibleByK obj = new Problem1015_SmallestIntegerDivisibleByK();
		System.out.println(obj.smallestRepunitDivByK(17));
	}
}
