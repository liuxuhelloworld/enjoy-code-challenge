package leetcode;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Problem0008_StringToInteger {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        while (i < chars.length && Character.isSpaceChar(chars[i])) {
            i++;
        }

        if (i == chars.length
            || (chars[i] != '+' && chars[i] != '-' && !Character.isDigit(chars[i]))) {
            return 0;
        }

        boolean negative = false;
        if (chars[i] == '+' || chars[i] == '-') {
            negative = chars[i] == '-';
            i++;
        }

        long ret = 0;
        while (i < chars.length && Character.isDigit(chars[i])) {
            ret = ret * 10 + (chars[i]-'0');
            if (ret > Integer.MAX_VALUE) {
                break;
            }
            i++;
        }
        ret = ret * (negative ? -1 : 1);

        if (ret > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ret < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) ret;
        }
    }

    public static void main(String[] args) {
        Problem0008_StringToInteger obj = new Problem0008_StringToInteger();
        System.out.println(obj.myAtoi("-13+8"));
        System.out.println(obj.myAtoi("42"));
        System.out.println(obj.myAtoi("   -42"));
        System.out.println(obj.myAtoi("4193 with words"));
        System.out.println(obj.myAtoi("words and 987"));
    }
}
