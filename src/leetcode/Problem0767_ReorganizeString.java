package leetcode;

/**
 * https://leetcode.cn/problems/reorganize-string/
 */
public class Problem0767_ReorganizeString {
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

		StringBuilder builder = new StringBuilder();

		int maxCountIdx, secondMaxCountIdx;
		while (true) {
			int[] top2CountCharsIdx = getTop2CountCharsIdx(count);

			maxCountIdx = top2CountCharsIdx[0];
			secondMaxCountIdx = top2CountCharsIdx[1];
			if (maxCountIdx == -1 && secondMaxCountIdx == -1) {
				break;
			}

			if (maxCountIdx != -1) {
				builder.append((char)('a' + maxCountIdx));
				count[maxCountIdx]--;
			}
			if (secondMaxCountIdx != -1) {
				builder.append((char)('a' + secondMaxCountIdx));
				count[secondMaxCountIdx]--;
			}
		}

		return builder.toString();
	}

	private int[] getTop2CountCharsIdx(int[] count) {
		int maxCount = 0, maxCountIdx = -1, secondMaxCount = 0, secondMaxCountIdx = -1;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > maxCount) {
				secondMaxCount = maxCount;
				secondMaxCountIdx = maxCountIdx;

				maxCount = count[i];
				maxCountIdx = i;
			} else if (count[i] > secondMaxCount) {
				secondMaxCount = count[i];
				secondMaxCountIdx = i;
			}
		}

		return new int[] {maxCountIdx, secondMaxCountIdx};
	}

	public static void main(String[] args) {
		Problem0767_ReorganizeString obj = new Problem0767_ReorganizeString();
		System.out.println(obj.reorganizeString("bababbbabbaabababbaa"));
		System.out.println(obj.reorganizeString("aabbcc"));
		System.out.println(obj.reorganizeString("vvvlo"));
		System.out.println(obj.reorganizeString("aab"));
		System.out.println(obj.reorganizeString("aaab"));
	}
}
