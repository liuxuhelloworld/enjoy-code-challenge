package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/queens-that-can-attack-the-king/
 */
public class Problem1222_QueensThatCanAttackTheKing {
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		int[][] board = new int[8][8];

		for (int[] queen : queens) {
			int queenRow = queen[0];
			int queenCol = queen[1];
			board[queenRow][queenCol] = 1;
		}

		int kingRow = king[0];
		int kingCol = king[1];
		board[kingRow][kingCol] = 2;

		List<List<Integer>> attacks = new ArrayList<>();

		// go right
		for (int j = kingCol + 1; j < 8; j++) {
			if (board[kingRow][j] == 1) {
				attacks.add(Arrays.asList(kingRow, j));
				break;
			}
		}

		// go up-right
		for (int i = kingRow - 1, j = kingCol + 1; i >= 0 && j < 8; i--, j++) {
			if (board[i][j] == 1) {
				attacks.add(Arrays.asList(i, j));
				break;
			}
		}

		// go up
		for (int i = kingRow - 1; i >= 0; i--) {
			if (board[i][kingCol] == 1) {
				attacks.add(Arrays.asList(i, kingCol));
				break;
			}
		}

		// go up-left
		for (int i = kingRow - 1, j = kingCol - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				attacks.add(Arrays.asList(i, j));
				break;
			}
		}

		// go left
		for (int j = kingCol - 1; j >= 0; j--) {
			if (board[kingRow][j] == 1) {
				attacks.add(Arrays.asList(kingRow, j));
				break;
			}
		}

		// go down-left
		for (int i = kingRow + 1, j = kingCol - 1; i < 8 && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				attacks.add(Arrays.asList(i, j));
				break;
			}
		}

		// go down
		for (int i = kingRow + 1; i < 8; i++) {
			if (board[i][kingCol] == 1) {
				attacks.add(Arrays.asList(i, kingCol));
				break;
			}
		}

		// go down-right
		for (int i = kingRow + 1, j = kingCol + 1; i < 8 && j < 8; i++, j++) {
			if (board[i][j] == 1) {
				attacks.add(Arrays.asList(i, j));
				break;
			}
		}

		return attacks;
	}

	public static void main(String[] args) {
		Problem1222_QueensThatCanAttackTheKing obj = new Problem1222_QueensThatCanAttackTheKing();
		int[][] queens = new int[][] {
			{0, 0},
			{1, 1},
			{2, 2},
			{3, 4},
			{3, 5},
			{4, 4},
			{4, 5}};

		int[] king = new int[] {3, 3};
		System.out.println(obj.queensAttacktheKing(queens, king));
	}
}
