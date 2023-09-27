package leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class Problem0567_PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 > len2) {
			return false;
		}

		int[] target = new int[26];
		int[] slide = new int[26];
		for (int i = 0; i < len1; i++) {
			target[s1.charAt(i) - 'a']++;
			slide[s2.charAt(i) - 'a']++;
		}

		if (Arrays.equals(target, slide)) {
			return true;
		} else {
			for (int i = 1; i <= len2 - len1; i++) {
				char out = s2.charAt(i - 1);
				char in = s2.charAt(i + len1 - 1);
				if (out == in) {
					continue;
				}
				slide[out - 'a']--;
				slide[in - 'a']++;
				if (Arrays.equals(target, slide)) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Problem0567_PermutationInString obj = new Problem0567_PermutationInString();
		System.out.println(obj.checkInclusion("adc", "dcda"));
		System.out.println(obj.checkInclusion("ab", "eidboaoo"));
	}
}
