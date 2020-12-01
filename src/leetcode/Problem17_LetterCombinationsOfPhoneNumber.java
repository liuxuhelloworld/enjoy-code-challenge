package leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Problem17_LetterCombinationsOfPhoneNumber {
	private static final Map<Character, Character[]> PHONE_NUMBER_TO_CHARACTERS = new HashMap<Character, Character[]>()
	{{
		put('2', new Character[] {'a', 'b', 'c'});
		put('3', new Character[] {'d', 'e', 'f'});
		put('4', new Character[] {'g', 'h', 'i'});
		put('5', new Character[] {'j', 'k', 'l'});
		put('6', new Character[] {'m', 'n', 'o'});
		put('7', new Character[] {'p', 'q', 'r', 's'});
		put('8', new Character[] {'t', 'u', 'v'});
		put('9', new Character[] {'w', 'x', 'y', 'z'});
	}};

	public List<String> letterCombinations(String digits) {
		int len = digits.length();
		if (len == 0) {
			return Collections.emptyList();
		}


		List<String> ret = new ArrayList<>();
		backtrack(ret, digits, 0, new StringBuffer());

		return ret;
	}

	private void backtrack(List<String> combinations, String digits, int index, StringBuffer combination) {
		if (index == digits.length()) {
			combinations.add(combination.toString());
		} else {
			char digit = digits.charAt(index);
			Character[] chars = PHONE_NUMBER_TO_CHARACTERS.get(digit);
			for (int i = 0; i < chars.length; i++) {
				combination.append(chars[i]);
				backtrack(combinations, digits, index+1, combination);
				combination.deleteCharAt(index);
			}
		}
	}

	public static void main(String[] args) {
		Problem17_LetterCombinationsOfPhoneNumber obj = new Problem17_LetterCombinationsOfPhoneNumber();
		System.out.println(obj.letterCombinations(""));
		System.out.println(obj.letterCombinations("2"));
		System.out.println(obj.letterCombinations("23"));
		System.out.println(obj.letterCombinations("234"));
	}
}
