package leetcode;

/**
 * https://leetcode.cn/problems/count-and-say/
 */
public class Problem0038_CountAndSay {
	public String countAndSay(int n) {
		String s = "1";
		for (int i = 2; i <= n; i++) {
			s = next(s);
		}

		return s;
	}

	private String next(String s) {
		char[] chars = s.toCharArray();
		char target = chars[0];
		int cnt = 0;

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			char cur = chars[i];
			if (cur == target) {
				cnt++;
			} else {
				builder.append(cnt);
				builder.append(target);

				target = cur;
				cnt = 1;
			}
		}

		builder.append(cnt);
		builder.append(target);

		return builder.toString();
	}

	public static void main(String[] args) {
		Problem0038_CountAndSay obj =	new Problem0038_CountAndSay();
		System.out.println(obj.countAndSay(1));
		System.out.println(obj.countAndSay(4));
	}
}
