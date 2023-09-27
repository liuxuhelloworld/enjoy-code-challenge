package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class Problem0557_ReverseWordsInString {
	public String reverseWords(String s) {
		String[] words = s.split(" ");
		String[] reversed = Arrays.stream(words)
			.map(e -> reverse(e))
			.collect(Collectors.toList())
			.toArray(new String[0]);

		return String.join(" ", reversed);
	}

	private String reverse(String s) {
		StringBuilder rev = new StringBuilder();
		for (int i = s.length()-1; i >= 0; i--) {
			rev.append(s.charAt(i));
		}
		return rev.toString();
	}
}
