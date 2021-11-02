package leetcode.string;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Problem5_LongestPalindromicSubstring {
    public String longestPalindromeSubstring(String s) {
        if (s == null) {
            return null;
        }

        int len = s.length();

        String ret = "";

        for (int i = 0; i < len; i++) {
            String expanded = expand(s, i, i);
            if (expanded.length() > ret.length()) {
                ret = expanded;
            }

            if (i > 0 && s.charAt(i) == s.charAt(i-1)) {
                expanded = expand(s, i-1, i);
                if (expanded.length() > ret.length()) {
                    ret = expanded;
                }
            }
        }

        return ret;
    }

    private String expand(String s, int left, int right) {
        int len = s.length();
        int i = left - 1, j = right + 1;
        while (i >= 0 && j < len) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }

        return s.substring(i+1, j);
    }

    public static void main(String[] args) {
        Problem5_LongestPalindromicSubstring obj = new Problem5_LongestPalindromicSubstring();
        System.out.println(obj.longestPalindromeSubstring("babad"));
        System.out.println(obj.longestPalindromeSubstring("cbbd"));
    }
}
