package leetcode;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 */
public class Problem0409_LongestPalindrome {
	public int longestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		int[] cnt = new int[52];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				cnt[ch - 'a']++;
			}
			if (ch >= 'A' && ch <= 'Z') {
				cnt[ch - 'A' + 26]++;
			}
		}

		int max = 0;
		boolean hasSingle = false;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] % 2 == 0) {
				max += cnt[i];
				cnt[i] = 0;
			} else {
				max += cnt[i] - 1;
				cnt[i] = 1;
				hasSingle = true;
			}
		}

		if (hasSingle) {
			max += 1;
		}

		return max;
	}

	public static void main(String[] args) {
		Problem0409_LongestPalindrome obj = new Problem0409_LongestPalindrome();
		System.out.println(obj.longestPalindrome("a"));
		System.out.println(obj.longestPalindrome("bb"));
		System.out.println(obj.longestPalindrome("abccccdd"));
		System.out.println(obj.longestPalindrome("abccccddaa"));
	}
}
