package leetcode;

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class Problem0012_IntegerToRoman {
	private static int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	private static String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	public String intToRoman(int num) {
		StringBuilder builder = new StringBuilder();

		int i = 0;
		while (num != 0) {
			int quotient = num / val[i];
			if (quotient != 0) {
				for (int j = 0; j < quotient; j++) {
					builder.append(symbol[i]);
				}
			}
			num = num % val[i];
			i++;
		}

		return builder.toString();
	}

	public static void main(String[] args) {
		Problem0012_IntegerToRoman obj = new Problem0012_IntegerToRoman();
		System.out.println(obj.intToRoman(3));
		System.out.println(obj.intToRoman(4));
		System.out.println(obj.intToRoman(9));
		System.out.println(obj.intToRoman(58));
		System.out.println(obj.intToRoman(1994));
	}
}
