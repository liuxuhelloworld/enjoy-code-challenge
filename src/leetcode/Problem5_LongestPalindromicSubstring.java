package leetcode;

public class Problem5_LongestPalindromicSubstring {
    public String longestPalindromeSubstring(String s) {
        if (s == null) {
            return null;
        }

        int len = s.length();

        String ret = "";

        // dp[i][j] represents whether s[i..j] is a palindromic substring
        boolean[][] dp = new boolean[len][len];

        for (int step = 0; step < len; step++) {
            for (int i = 0; i < len-step; i++) {
                if (step == 0) {
                    // s[i] is a palindromic substring of length one
                    dp[i][i] = true;
                } else if (step == 1) {
                    // s[i..i+1] is a palindromic substring of length two if s[i] == s[i+1]
                    dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
                } else {
                    // s[i..i+step] is a palindromic substring of length step
                    // if s[i] == s[i+step] and s[i+1..i+step-1] is also a palindromic substring
                    dp[i][i+step] = dp[i+1][i+step-1] && s.charAt(i) == s.charAt(i+step);
                }

                if (dp[i][i+step] && step+1 > ret.length()) {
                    ret = s.substring(i, i+step+1);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Problem5_LongestPalindromicSubstring obj = new Problem5_LongestPalindromicSubstring();
        System.out.println(obj.longestPalindromeSubstring("babad"));
        System.out.println(obj.longestPalindromeSubstring("cbbd"));
    }
}
