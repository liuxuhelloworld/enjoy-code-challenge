package leetcode.slidingwindow;

public class Problem1234_ReplaceSubstringForBalancedString {
	public int balancedString(String s) {
		int length = s.length();

		int[] cnt = new int[4]; // 0-Q, 1-W, 2-E, 3-R

		char[] chars = s.toCharArray();
		for (int i = 0; i < length; i++) {
			cnt[index(chars[i])]++;
		}

		if (isMayBeBalanced(cnt, length)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		int start = 0, end = 0; // start is inclusive, end is exclusive
		while (start <= end && start < length) {
			while (end < length) {
				if (isMayBeBalanced(cnt, length)) {
					break;
				} else {
					cnt[index(chars[end])]--;
					end++;
				}
			}

			if (isMayBeBalanced(cnt, length)) {
				min = Math.min(end - start, min);
			}

			cnt[index(chars[start])]++;
			start++;
		}

		return min;
	}

	private int index(char ch) {
		int index = -1;

		switch (ch) {
			case 'Q':
				index = 0;
				break;
			case 'W':
				index = 1;
				break;
			case 'E':
				index = 2;
				break;
			case 'R':
				index = 3;
				break;
			default:
				break;
		}

		return index;
	}

	private boolean isMayBeBalanced(int[] cnt, int length) {
		int ceil = length/4;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > ceil) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Problem1234_ReplaceSubstringForBalancedString obj = new Problem1234_ReplaceSubstringForBalancedString();
		System.out.println(obj.balancedString("WQWRQQQW"));
	}
}
