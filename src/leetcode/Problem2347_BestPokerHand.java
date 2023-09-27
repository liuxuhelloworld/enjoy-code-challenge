package leetcode;

/**
 * https://leetcode.cn/problems/best-poker-hand/
 */
public class Problem2347_BestPokerHand {
	public String bestHand(int[] ranks, char[] suits) {
		boolean isFlush = isFlush(suits);
		if (isFlush) {
			return "Flush";
		}

		int[] count = new int[14]; // 0 index is not used
		for (int i = 0; i < ranks.length; i++) {
			count[ranks[i]]++;
		}

		int max = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > max) {
				max = count[i];
			}
		}

		if (max >= 3) {
			return "Three of a Kind";
		} else if (max == 2) {
			return "Pair";
		} else {
			return "High Card";
		}
	}

	private boolean isFlush(char[] suits) {
		for (int i = 1; i < suits.length; i++) {
			if (suits[i] != suits[i-1]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Problem2347_BestPokerHand obj = new Problem2347_BestPokerHand();

		int[] ranks = new int[] {10, 10, 2, 12, 9};
		char[] suits = new char[] {'d', 'a', 'a', 'b', 'c'};
		System.out.println(obj.bestHand(ranks, suits));
	}
}
