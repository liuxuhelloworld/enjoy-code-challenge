package leetcode;

/**
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Problem50_Pow {
	public double myPow(double x, int n) {
		double res = pow(x, Math.abs(n));

		if (n < 0) {
			return 1 / res;
		} else {
			return res;
		}
	}

	private double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}

		double res = x;
		long i = 1;
		while((i = i + i) <= n) {
			res *= res;
		}

		return res * pow(x, n - (int)(i/2));
	}

	public static void main(String[] args) {
		Problem50_Pow obj = new Problem50_Pow();
		System.out.println(obj.myPow(0.00001, 2147483647));
		System.out.println(obj.myPow(2.0, 10));
		System.out.println(obj.myPow(2.1, 3));
		System.out.println(obj.myPow(2.0, -2));
	}
}
