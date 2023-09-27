package leetcode;

/**
 * https://leetcode.cn/problems/add-strings/
 */
public class Problem0415_AddStrings {
	public String addStrings(String num1, String num2) {
		StringBuilder builder = new StringBuilder();

		int len1 = num1.length();
		int len2 = num2.length();

		int carry = 0;
		for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
			int val1 = 0;
			if (i >= 0) {
				val1 = num1.charAt(i) - '0';
			}
			int val2 = 0;
			if (j >= 0) {
				val2 = num2.charAt(j) - '0';
			}

			int sum = val1 + val2 + carry;
			int remain = sum % 10;
			carry = sum / 10;

			builder.append((char) (remain + '0'));
		}

		if (carry == 1) {
			builder.append("1");
		}

		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		Problem0415_AddStrings obj = new Problem0415_AddStrings();
		System.out.println(obj.addStrings("11", "123"));
	}
}
