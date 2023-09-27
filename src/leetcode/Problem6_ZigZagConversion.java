package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class Problem6_ZigZagConversion {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len == 0) {
            return "";
        }

        numRows = Math.min(numRows, len);
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        boolean goingDown = false;

        int curRow = 0;
        for (int k = 0; k < len; k++) {
            rows.get(curRow).append(s.charAt(k));

            if (curRow == 0 || curRow == numRows-1) {
                goingDown = !goingDown;
            }

            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        Problem6_ZigZagConversion prob = new Problem6_ZigZagConversion();
        System.out.println(prob.convert("PAYPALISHIRING", 3));
        System.out.println(prob.convert("PAYPALISHIRING", 4));
    }
}
