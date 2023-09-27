package leetcode.dfs;

/**
 * https://leetcode.cn/problems/stone-game-ii/
 */
public class Problem1140_StoneGame {
	public int stoneGameII(int[] piles) {
		return dfs(piles, 0, true, 1, 0, 0);
	}

	private int dfs(int[] piles, int idx, boolean isAlice, int m, int aliceStones, int maxAliceStones) {
		if (idx >= piles.length) {
			return aliceStones;
		}

		int remainPiles = piles.length - idx;

		int canChosen = Math.min(remainPiles, 2 * m);
		for (int x = 1; x <= canChosen; x++) {
			int ret = dfs(piles, idx + x, !isAlice,
				Math.max(x, m), isAlice ? aliceStones + piles[idx] : aliceStones, maxAliceStones);
			if (ret > maxAliceStones) {
				maxAliceStones = ret;
			}
		}

		return maxAliceStones;
	}

	public static void main(String[] args) {
		Problem1140_StoneGame obj = new Problem1140_StoneGame();
		System.out.println(obj.stoneGameII(new int[] {2, 7, 9, 4, 4}));
	}
}
