package leetcode;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class Problem0844_BackspaceStringCompare {
	public boolean backspaceCompare(String s, String t) {
		char[] schars = s.toCharArray();
		char[] tchars = t.toCharArray();

		int i = schars.length, j = tchars.length;
		while (true) {
			i = idxOfNextRightMostChar(schars, i);
			j = idxOfNextRightMostChar(tchars, j);
			if (i == -1 && j == -1) {
				return true;
			} else if (i != -1 && j != -1) {
				char ch1 = schars[i];
				char ch2 = tchars[j];
				if (ch1 != ch2) {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	private int idxOfNextRightMostChar(char[] chars, int idx) {
		int skip = 0;

		for (int i = --idx; i >= 0; i--) {
			char ch = chars[i];
			if (ch == '#') {
				skip++;
			} else {
				if (skip > 0) {
					skip--;
				} else {
					return i;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Problem0844_BackspaceStringCompare obj = new Problem0844_BackspaceStringCompare();
		System.out.println(obj.backspaceCompare("ab#c", "ad#c"));
		System.out.println(obj.backspaceCompare("ab##", "c#d#"));
		System.out.println(obj.backspaceCompare("a#c", "b"));
	}
}
