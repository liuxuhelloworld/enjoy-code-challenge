package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Problem3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringWithoutRepeatingCharacters(String s) {
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
        System.out.println(obj.lengthOfLongestSubstringWithoutRepeatingCharacters("tmmzuxt"));
        System.out.println(obj.lengthOfLongestSubstringWithoutRepeatingCharacters(" "));
        System.out.println(obj.lengthOfLongestSubstringWithoutRepeatingCharacters("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstringWithoutRepeatingCharacters("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstringWithoutRepeatingCharacters("pwwkew"));
    }
}
