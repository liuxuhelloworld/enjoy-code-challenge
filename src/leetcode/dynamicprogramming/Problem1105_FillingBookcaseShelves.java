package leetcode.dynamicprogramming;

/**
 * https://leetcode.cn/problems/filling-bookcase-shelves/
 */
public class Problem1105_FillingBookcaseShelves {
	public int minHeightShelves(int[][] books, int shelfWidth) {
		int length = books.length;

		int[] thick = new int[length];
		int[] height = new int[length];

		for (int i = 0; i < length; i++) {
			thick[i] = books[i][0];
			height[i] = books[i][1];
		}

		// dp[i][j] represents min height to fill books[i..j]
		int[][] dp = new int[length][length];

		for (int i = 0; i < length; i++) {
			dp[i][i] = height[i];
		}

		for (int gap = 1; gap < length; gap++) {
			for (int i = 0; i < length - gap; i++) {
				int thickSum = 0;
				int maxBookHeight = height[i+gap];
				int minShelfHeight = Integer.MAX_VALUE;
				for (int k = i + gap; k >= i; k--) {
					thickSum += thick[k];
					if (height[k] > maxBookHeight) {
						maxBookHeight = height[k];
					}

					if (thickSum <= shelfWidth) {
						if (k == 0) {
							if (maxBookHeight < minShelfHeight) {
								minShelfHeight = maxBookHeight;
							}
						} else {
							if (dp[i][k-1] + maxBookHeight < minShelfHeight) {
								minShelfHeight = dp[i][k-1] + maxBookHeight;
							}
						}
					}
				}

				dp[i][i+gap] = minShelfHeight;
			}
		}

		return dp[0][length-1];
	}

	public int minHeightShelves2(int[][] books, int shelfWidth) {
		int length = books.length;

		int[] thick = new int[length];
		int[] height = new int[length];

		for (int i = 0; i < length; i++) {
			thick[i] = books[i][0];
			height[i] = books[i][1];
		}

		// dp[i] represents min height to fill books[0..i]
		int[] dp = new int[length];
		dp[0] = height[0];

		for (int i = 1; i < length; i++) {
			int thickSum = 0;
			int maxBookHeight = height[i];
			int minShelfHeight = Integer.MAX_VALUE;
			for (int k = i; k >= 0; k--) {
				thickSum += thick[k];
				if (height[k] > maxBookHeight) {
					maxBookHeight = height[k];
				}

				if (thickSum <= shelfWidth) {
					if (k == 0) {
						if (maxBookHeight < minShelfHeight) {
							minShelfHeight = maxBookHeight;
						}
					} else {
						if (dp[k - 1] + maxBookHeight < minShelfHeight) {
							minShelfHeight = dp[k - 1] + maxBookHeight;
						}
					}
				}
			}

			dp[i] = minShelfHeight;
		}

		return dp[length-1];
	}

	public static void main(String[] args) {
		Problem1105_FillingBookcaseShelves obj = new Problem1105_FillingBookcaseShelves();
		int[][] books = new int[][] {
			{1, 1},
			{2, 3},
			{2, 3},
			{1, 1},
			{1, 1},
			{1, 1},
			{1, 2}};

		System.out.println(obj.minHeightShelves2(books, 4));
	}
}
