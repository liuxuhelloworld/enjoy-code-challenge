package leetcode;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Problem122_BestTimeToBuyAndSellStock {
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;

		if (prices.length <= 1) {
			return 0;
		}

		for (int i = 0; i < prices.length; i++) {
			while (i < prices.length - 1 && prices[i+1] <= prices[i]) {
				i++;
			}
			int buyPrice = prices[i];
			while (i < prices.length - 1 && prices[i+1] >= prices[i]) {
				i++;
			}
			int soldPrice = prices[i];
			maxProfit += soldPrice - buyPrice;
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {7, 7, 7, 7 ,7}));
		System.out.println(maxProfit(new int[] {7, 6, 4, 3 ,1}));
		System.out.println(maxProfit(new int[] {1, 2, 3, 4 ,5}));
		System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
	}
}
