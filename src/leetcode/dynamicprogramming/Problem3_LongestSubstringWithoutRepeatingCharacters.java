package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public int lengthOfLongestSubstringWithoutRepeatingCharactersV2(String s) {
        int len = s.length();

        Set<Character> noRepeat = new HashSet<>();

        int max = 0;
        for (int i = 0, j = 0; i < len && j < len; i = i + 1) {
            while (j < len && !noRepeat.contains(s.charAt(j))) {
                noRepeat.add(s.charAt(j));
                j++;
            }

            if (j - i > max) {
                max = j - i;
            }

            if (j == len) {
                break;
            }

            noRepeat.remove(s.charAt(i));
        }

        return max;
    }

    public int lengthOfLongestSubstringWithoutRepeatingCharactersV3(String s) {
        int len = s.length();

        Map<Character, Integer> index = new HashMap<>();

        int max = 0;
        int windowStart = 0;
        for (int i = 0; i < len; i++) {
            while (i < len && index.getOrDefault(s.charAt(i), -1) < windowStart) {
                index.put(s.charAt(i), i);
                i++;
            }

            int windowSize = i - windowStart;
            max = Math.max(max, windowSize);

            if (i == len) {
                break;
            }

            int origIndex = index.get(s.charAt(i));
            index.put(s.charAt(i), i);
            windowStart = origIndex + 1;
        }

        return max;
    }

    public int lengthOfLongestSubstringWithoutRepeatingCharactersV4(String s) {
        int len = s.length();

        Map<Character, Integer> index = new HashMap<>();

        int max = 0;
        for (int left = 0, right = 0; right < len; right++) {
            char c = s.charAt(right);
            if (index.containsKey(c)) {
                left = Math.max(left, index.get(c)+1);
            }
            index.put(c, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public int lengthOfLongestSubstringWithoutRepeatingCharactersV5(String s) {
        int len = s.length();

        int[] index = new int[256];
        for (int i = 0; i < index.length; i++) {
            index[i] = -1;
        }

        int max = 0;
        for (int left = 0, right = 0; right < len; right++) {
            char c = s.charAt(right);
            left = Math.max(left, index[c]+1);
            index[c] = right;
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
