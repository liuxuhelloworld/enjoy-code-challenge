package leetcode;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class Problem0043_MultiplyStrings {
	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();

		if (len1 == 0 || len2 == 0) {
			throw new IllegalArgumentException();
		}

		String multiplicand, multiplier;
		if (len1 < len2) {
			multiplicand = num2;
			multiplier = num1;
		} else {
			multiplicand = num1;
			multiplier = num2;
		}

		if (multiplier.equals("0") || multiplicand.equals("0")) {
			return "0";
		}

		String leftShift = "";
		String result = "";
		for (int i = multiplier.length()-1; i >= 0; i--) {
			int ch = multiplier.charAt(i) - '0';

			result = addTwoStrings(result, multiplyByDigit(multiplicand, ch) + leftShift);
			leftShift += "0";
		}

		return result;
	}

	private String multiplyByDigit(String num, int digit) {
		if (!(digit >= 1 && digit <= 9)) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		int carry = 0;
		for (int i = num.length() - 1; i >= 0; i--) {
			int ch = num.charAt(i) - '0';

			int product = ch * digit + carry;
			int remainder = product % 10;
			carry = product / 10;

			builder.append((char)(remainder + '0'));
		}
		if (carry != 0) {
			builder.append((char)(carry + '0'));
		}

		return builder.reverse().toString();
	}

	private String addTwoStrings(String num1, String num2) {
		StringBuilder builder = new StringBuilder();

		String reversedNum1 = new StringBuilder(num1).reverse().toString();
		String reversedNum2 = new StringBuilder(num2).reverse().toString();

		int len1 = reversedNum1.length();
		int len2 = reversedNum2.length();

		int i, j;
		int carry = 0;
		for (i = 0, j = 0; i < len1 || j < len2; i++, j++) {
			int ch1, ch2;

			if (i < len1) {
				ch1 = reversedNum1.charAt(i) - '0';
			} else {
				ch1 = 0;
			}
			if (j < len2) {
				ch2 = reversedNum2.charAt(j) - '0';
			} else {
				ch2 = 0;
			}

			int sum = ch1 + ch2 + carry;

			int remainder = sum % 10;
			carry = sum / 10;
			builder.append((char)(remainder + '0'));
		}

		if (carry != 0) {
			builder.append((char)(carry + '0'));
		}

		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		Problem0043_MultiplyStrings obj = new Problem0043_MultiplyStrings();
		System.out.println(obj.multiply("9", "9"));
		System.out.println(obj.multiply("2", "0"));
		System.out.println(obj.multiply("2", "3"));
		System.out.println(obj.multiply("123", "456"));
	}
}
