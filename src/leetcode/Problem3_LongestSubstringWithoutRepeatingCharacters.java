package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Problem3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringWithoutRepeatingCharacters(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        // dp[i] represents the length of longest substring that end with s[i] and has no repeating characters
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            int last = lastIndexOf(s, i-dp[i-1],i-1, s.charAt(i));
            if (last == -1) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = i-last;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    private int lastIndexOf(String s, int start, int end, char c) {
        for (int i = end; i >= start; i--) {
            if (s.charAt(i) == c) {
                return i;
            }
        }

        return -1;
    }

    public int lengthOfLongestSubstringWithoutRepeatingCharacters2(String s) {
        int len = s.length();

        Map<Character, Integer> index = new HashMap<>();

        int max = 0;
        int left = 0;
        for (int right = 0; right < len; right++) {
            char c = s.charAt(right);
            if (index.containsKey(c)) {
                int lastIndex = index.get(c);
                if (lastIndex + 1 > left) {
                    left = lastIndex + 1;
                }
            }
            index.put(c, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Problem3_LongestSubstringWithoutRepeatingCharacters obj =
            new Problem3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstringWithoutRepeatingCharacters("abba"));
        System.out.println(obj.lengthOfLongestSubstringWithoutRepeatingCharacters(" "));
        System.out.println(obj.lengthOfLongestSubstringWithoutRepeatingCharacters("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstringWithoutRepeatingCharacters("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstringWithoutRepeatingCharacters("pwwkew"));
    }
}
