package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
public class Problem0036_ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    Set<Character>[] rows = new HashSet[9];
    Set<Character>[] cols = new HashSet[9];
    Set<Character>[] cells = new HashSet[9];

    for (int i = 0; i < 9; i++) {
      rows[i] = new HashSet<>();
      cols[i] = new HashSet<>();
      cells[i] = new HashSet<>();
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char ch = board[i][j];
        if (ch == '.') {
          continue;
        }

        if (rows[i].contains(ch)) {
          return false;
        } else {
          rows[i].add(ch);
        }

        if (cols[j].contains(ch)) {
          return false;
        } else {
          cols[j].add(ch);
        }

        int cellIndex = (i/3)*3 + j/3;
        if (cells[cellIndex].contains(ch)) {
          return false;
        } else {
          cells[cellIndex].add(ch);
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Problem0036_ValidSudoku obj = new Problem0036_ValidSudoku();

    char[][] board = new char[][] {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    };

    System.out.println(obj.isValidSudoku(board));
  }
}
