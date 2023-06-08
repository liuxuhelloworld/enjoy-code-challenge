package leetcode.greedy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/mice-and-cheese/
 */
public class Problem2611_MiceAndCheese {
	public int miceAndCheese(int[] reward1, int[] reward2, int k) {
		int n = reward1.length;

		int maxCheese;
		if (k <= n/2) {
			maxCheese = maxCheese(reward1, reward2, k);
		} else {
			maxCheese = maxCheese(reward2, reward1, n-k);
		}

		return maxCheese;
	}

	private int maxCheese(int[] reward1, int[] reward2, int k) {
		int n = reward1.length;

		int[] diff = new int[n];
		for (int i = 0; i < n; i++) {
			diff[i] = reward1[i] - reward2[i];
		}

		boolean[] used = new boolean[n];

		for (int i = 0; i < k; i++) {
			int maxDiffIdx = maxDiffIdx(diff);
			used[maxDiffIdx] = true;
			diff[maxDiffIdx] = Integer.MIN_VALUE;
		}

		int maxCheese = 0;
		for (int i = 0; i < n; i++) {
			if (used[i]) {
				maxCheese += reward1[i];
			} else {
				maxCheese += reward2[i];
			}
		}

		return maxCheese;
	}

	private int maxDiffIdx(int[] diff) {
		int maxDiffIdx = 0;
		int maxDiff = diff[0];
		for (int i = 0; i < diff.length; i++) {
			if (diff[i] > maxDiff) {
				maxDiff = diff[i];
				maxDiffIdx = i;
			}
		}

		return maxDiffIdx;
	}

	public int miceAndCheese2(int[] reward1, int[] reward2, int k) {
		int n = reward1.length;

		int[] diff = new int[n];
		for (int i = 0; i < n; i++) {
			diff[i] = reward1[i] - reward2[i];
		}

		Arrays.sort(diff);

		int maxCheese = 0;
		for (int i = 0; i < n; i++) {
			maxCheese += reward2[i];
		}

		for (int i = 0; i < k; i++) {
			maxCheese += diff[n-1-i];
		}

		return maxCheese;
	}

	public static void main(String[] args) {
		Problem2611_MiceAndCheese obj = new Problem2611_MiceAndCheese();
		int[] reward1 = new int[] {1, 1, 3, 4};
		int[] reward2 = new int[] {4, 4, 1, 1};
		System.out.println(obj.miceAndCheese2(reward1, reward2, 2));
	}
}
