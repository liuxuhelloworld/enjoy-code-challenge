package leetcode;

/**
 * https://leetcode.cn/problems/reorganize-string/
 */
public class Problem767_ReorganizeString {
	public String reorganizeString(String s) {
		char[] origin = s.toCharArray();

		int maxCount = 0, allCount = origin.length;

		int[] count = new int[26];
		for (int i = 0; i < origin.length; i++) {
			int idx = origin[i] - 'a';
			count[idx]++;

			if (count[idx] > maxCount) {
				maxCount = count[idx];
			}
		}

		if (allCount - maxCount < maxCount - 1) {
			return "";
		}

		char[] reorganized = new char[origin.length];

		return backtrack(reorganized, count);
	}

	private String backtrack(char[] reorganized, int[] count) {
		int idx = getNonZeroMaxCount(count);
		if (idx == -1) {
			return String.valueOf(reorganized);
		}

		char ch = (char) ('a' + idx);

		for (int i = 0; i < reorganized.length; i++) {
			if (reorganized[i] != 0) {
				continue;
			}

			if (i > 0
				&& reorganized[i-1] == ch) {
				continue;
			}

			if (i < reorganized.length-1
				&& reorganized[i+1] == ch) {
				continue;
			}

			reorganized[i] = ch;
			count[idx]--;

			String s = backtrack(reorganized, count);
			if (!s.isEmpty()) {
				return s;
			}

			count[idx]++;
			reorganized[i] = 0;
		}

		return "";
	}

	private int getNonZeroMaxCount(int[] count) {
		int idx = -1;
		int max = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > max) {
				max = count[i];
				idx = i;
			}
		}

		return idx;
	}

	public static void main(String[] args) {
		Problem767_ReorganizeString obj = new Problem767_ReorganizeString();
		System.out.println(obj.reorganizeString("bababbbabbaabababbaa"));
		System.out.println(obj.reorganizeString("aabbcc"));
		System.out.println(obj.reorganizeString("vvvlo"));
		System.out.println(obj.reorganizeString("aab"));
		System.out.println(obj.reorganizeString("aaab"));
	}
}
