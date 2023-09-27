package leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class Problem0344_ReverseString {
	public void reverseString(char[] s) {
		for (int i = 0, j = s.length - 1; i < j; i++, j--) {
			char tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
		}
	}

	public static void main(String[] args) {
		Problem0344_ReverseString obj = new Problem0344_ReverseString();
		obj.reverseString(new char[] {'h', 'e', 'l', 'l', 'o'});
	}
}
