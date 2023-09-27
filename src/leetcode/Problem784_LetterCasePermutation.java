package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-case-permutation/
 */
public class Problem784_LetterCasePermutation {
	public List<String> letterCasePermutation(String s) {
		List<String> result = new ArrayList<>();
		char[] charArr = s.toCharArray();
		backtrack(result, 0, charArr);

		return result;
	}

	private void backtrack(List<String> result, int curPos, char[] charArr) {
		if (curPos == charArr.length) {
			result.add(new String(charArr));
			return;
		}

		char curChar = charArr[curPos];

		if (Character.isLetter(curChar)) {
			charArr[curPos] = Character.toLowerCase(curChar);
			backtrack(result, curPos + 1, charArr);

			charArr[curPos] = Character.toUpperCase(curChar);
			backtrack(result, curPos + 1, charArr);
		} else {
			backtrack(result, curPos + 1, charArr);
		}
	}

	public static void main(String[] args) {
		Problem784_LetterCasePermutation obj = new Problem784_LetterCasePermutation();
		List<String> result = obj.letterCasePermutation("a1b2");
		System.out.println(result);

		result = obj.letterCasePermutation("3z4");
		System.out.println(result);

		result = obj.letterCasePermutation("12345");
		System.out.println(result);

		result = obj.letterCasePermutation("0");
		System.out.println(result);
	}
}
