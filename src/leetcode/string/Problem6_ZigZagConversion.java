package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class Problem6_ZigZagConversion {
    private enum Direction {DOWN, UP}

    public String convert(String s, int numRows) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }

        int numCols = computeNumCols(len, numRows);

        char[][] zigzag = new char[numRows][numCols];

        Direction direction = Direction.DOWN;

        int i = 0, j = 0;
        for (int k = 0; k < len; k++) {
            zigzag[i][j] = s.charAt(k);

            // compute the next coordinate to assign value
            if (direction.equals(Direction.DOWN)) {
                if (i < numRows-1) {
                    i++;
                } else {
                    direction = Direction.UP;
                    i--;
                    j++;
                }
            } else {
                if (i > 0) {
                    i--;
                    j++;
                } else {
                    direction = Direction.DOWN;
                    i++;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (i = 0; i < numRows; i++) {
           for (j = 0; j < numCols; j++) {
               if (zigzag[i][j] != 0) {
                   builder.append(zigzag[i][j]);
               }
           }
        }

        return builder.toString();
    }

    private int computeNumCols(int len, int numRows) {
        int oneGroupSize = numRows + numRows - 2;
        int oneGroupCols = numRows - 1;
        int remainCharsNum = len % oneGroupSize;

        int numCols = (len/oneGroupSize)*oneGroupCols;
        if (remainCharsNum > 0) {
            numCols += 1;
        }
        if (remainCharsNum > numRows) {
            numCols += remainCharsNum - numRows;
        }

        return numCols;
    }

    public String convertV2(String s, int numRows) {
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

    public String convertV3(String s, int numRows) {
        int len = s.length();
        if (len == 0) {
            return "";
        }

        numRows = Math.min(len, numRows);
        if (numRows == 1) {
            return s;
        }

        StringBuilder ret = new StringBuilder();

        for (int curRow = 0; curRow < numRows; curRow++) {
            int step1, step2;
            if (curRow == 0 || curRow == numRows-1) {
                step1 = step2 = (numRows-1) * 2;
            } else {
                step1 = (numRows-1 - curRow) * 2;
                step2 = curRow * 2;
            }

            int pos = curRow;
            ret.append(s.charAt(pos));
            while(true) {
                pos += step1;
                if (pos < len) {
                    ret.append(s.charAt(pos));
                } else {
                    break;
                }

                pos += step2;
                if (pos < len) {
                    ret.append(s.charAt(pos));
                } else {
                    break;
                }
            }
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        Problem6_ZigZagConversion prob = new Problem6_ZigZagConversion();
        System.out.println(prob.convertV3("PAYPALISHIRING", 3));
        System.out.println(prob.convertV3("PAYPALISHIRING", 4));
    }
}
