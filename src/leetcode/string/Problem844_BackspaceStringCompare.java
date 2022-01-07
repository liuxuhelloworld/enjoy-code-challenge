package leetcode.string;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class Problem844_BackspaceStringCompare {
	public boolean backspaceCompare(String s, String t) {
		String backspaced1 = backspace(s);
		String backspaced2 = backspace(t);

		if (backspaced1.equals(backspaced2)) {
			return true;
		} else {
			return false;
		}
	}

	private String backspace(String s) {
		char[] chars = s.toCharArray();

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < chars.length; i++) {
			if (Character.isLowerCase(chars[i])) {
				builder.append(chars[i]);
			} else {
				if (builder.length() > 0) {
					builder.deleteCharAt(builder.length() - 1);
				}
			}
		}

		return builder.toString();
	}

	public static void main(String[] args) {
		Problem844_BackspaceStringCompare obj = new Problem844_BackspaceStringCompare();
		System.out.println(obj.backspaceCompare("ab#c", "ad#c"));
		System.out.println(obj.backspaceCompare("ab##", "c#d#"));
		System.out.println(obj.backspaceCompare("a#c", "b"));
	}
}
