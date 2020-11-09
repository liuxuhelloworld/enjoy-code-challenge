package leetcode;

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class Problem12_IntegerToRoman {
	private static String[][] romanSymbol = {
		{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
		{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
		{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
		{"", "M", "MM", "MMM"}
	};

	public String intToRoman(int num) {
		StringBuilder builder = new StringBuilder();

		int op = 1000;
		while (num != 0) {
			int quotient = num / op;
			int remainder = num % op;

			if (quotient != 0) {
				builder.append(romanSymbol[(int)Math.log10(op)][quotient]);
			}

			op = op / 10;
			num = remainder;
		}

		return builder.toString();
	}

	public static void main(String[] args) {
		Problem12_IntegerToRoman obj = new Problem12_IntegerToRoman();
//		System.out.println(obj.intToRoman(3));
//		System.out.println(obj.intToRoman(4));
//		System.out.println(obj.intToRoman(9));
//		System.out.println(obj.intToRoman(58));
		System.out.println(obj.intToRoman(1994));
	}
}
