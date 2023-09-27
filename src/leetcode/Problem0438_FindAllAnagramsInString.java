package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class Problem0438_FindAllAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ret = new ArrayList<>();

		int plen = p.length();
		int slen = s.length();
		if (slen < plen) {
			return ret;
		}

		int[] target = new int[26];
		int[] rolling = new int[26];

		for (int i = 0; i < plen; i++) {
			target[p.charAt(i) - 'a']++;
			rolling[s.charAt(i) - 'a']++;
		}
		if (compare(target, rolling)) {
			ret.add(0);
		}

		for (int i = 1; i <= s.length() - plen; i++) {
			if (s.charAt(i-1) != s.charAt(i+plen-1)) {
				rolling[s.charAt(i-1) - 'a']--;
				rolling[s.charAt(i+plen-1) - 'a']++;
			}

			if (compare(target, rolling)) {
				ret.add(i);
			}
		}

		return ret;
	}

	private boolean compare(int[] target, int[] rolling) {
		for (int i = 0; i < 26; i++) {
			if (target[i] != rolling[i]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Problem0438_FindAllAnagramsInString obj = new Problem0438_FindAllAnagramsInString();
		System.out.println(obj.findAnagrams("cbaebabacd", "abc"));
		System.out.println(obj.findAnagrams("abab", "ab"));
	}
}
