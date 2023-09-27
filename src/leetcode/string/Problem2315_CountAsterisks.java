package leetcode.string;

/**
 * https://leetcode.cn/problems/count-asterisks/
 */
public class Problem2315_CountAsterisks {
	public int countAsterisks(String s) {
		int cnt = 0;

		char[] chars = s.toCharArray();

		boolean excluded = false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '*' && !excluded) {
				cnt++;
			}
			if (chars[i] == '|') {
				excluded = !excluded;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		Problem2315_CountAsterisks obj = new Problem2315_CountAsterisks();
		System.out.println(obj.countAsterisks("l|*e*et|c**o|*de|"));
		System.out.println(obj.countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
	}
}
