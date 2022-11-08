package leetcode.math;

/**
 * https://leetcode.cn/problems/palindrome-number/
 */
public class Problem9_PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		int y = x, reversed = 0;
		while (y != 0) {
			int remain = y % 10;
			reversed = reversed*10 + remain;
			y = y / 10;
		}

		return x == reversed;
	}

	public static void main(String[] args) {
		Problem9_PalindromeNumber obj = new Problem9_PalindromeNumber();
		System.out.println(obj.isPalindrome(3));
		System.out.println(obj.isPalindrome(10));
		System.out.println(obj.isPalindrome(121));
		System.out.println(obj.isPalindrome(-121));
	}
}
