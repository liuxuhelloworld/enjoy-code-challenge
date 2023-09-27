package leetcode;

/**
 * https://leetcode.cn/problems/valid-palindrome/
 */
public class Problem125_ValidPalindrome {
	public boolean isPalindrome(String s) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if ((ch >= 'a' && ch <= 'z')
				|| (ch >= '0' && ch <= '9')) {
				builder.append(ch);
			} else if (ch >= 'A' && ch <= 'Z') {
				builder.append((char)(ch - 'A' + 'a'));
			}
		}

		char[] chars = builder.toString().toCharArray();
		for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
			if (chars[i] != chars[j]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Problem125_ValidPalindrome obj = new Problem125_ValidPalindrome();
		System.out.println(obj.isPalindrome(""));
		System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(obj.isPalindrome("race a car"));
	}
}
