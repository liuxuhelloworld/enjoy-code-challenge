package leetcode.recursion;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Problem17_LetterCombinationsOfPhoneNumber {
	private static final Map<Character, String> PHONE_NUMBER_TO_CHARACTERS = new HashMap<Character, String>()
	{{
		put('2', "abc");
		put('3', "def");
		put('4', "ghi");
		put('5', "jkl");
		put('6', "mno");
		put('7', "pqrs");
		put('8', "tuv");
		put('9', "wxyz");
	}};

	public List<String> letterCombinations(String digits) {
		return letterCombinationRecur(digits, 0, digits.length()-1);
	}

	private List<String> letterCombinationRecur(String digits, int start, int end) {
		if (start > end) {
			return Collections.emptyList();
		}

		char digit = digits.charAt(start);
		String chars = PHONE_NUMBER_TO_CHARACTERS.get(digit);
		List<String> tails = letterCombinationRecur(digits, start + 1, end);
		List<String> combinations = new ArrayList<>();
		for (char ch : chars.toCharArray()) {
			if (tails.size() > 0) {
				for (String tail : tails) {
					combinations.add(ch + tail);
				}
			} else {
				combinations.add(ch + "");
			}
		}

		return combinations;
	}

	public static void main(String[] args) {
		Problem17_LetterCombinationsOfPhoneNumber obj = new Problem17_LetterCombinationsOfPhoneNumber();
		System.out.println(obj.letterCombinations(""));
		System.out.println(obj.letterCombinations("2"));
		System.out.println(obj.letterCombinations("23"));
		System.out.println(obj.letterCombinations("234"));
	}
}
