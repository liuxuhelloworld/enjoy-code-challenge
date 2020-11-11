package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	private static int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	private static String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

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

	public String intToRomanV2(int num) {
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
		Problem12_IntegerToRoman obj = new Problem12_IntegerToRoman();
		System.out.println(obj.intToRomanV2(3));
		System.out.println(obj.intToRomanV2(4));
		System.out.println(obj.intToRomanV2(9));
		System.out.println(obj.intToRomanV2(58));
		System.out.println(obj.intToRomanV2(1994));
	}
}
