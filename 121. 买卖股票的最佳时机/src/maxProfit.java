//r贪心法
class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int min = prices[0];
		int[] dp = new int[prices.length];
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
//			左取最小值
			if (prices[i] < min) {
				min = prices[i];
			}
//			右取最大值
			dp[i] = Math.max(prices[i] - min, dp[i - 1]);
		}
		return dp[prices.length - 1];
	}
}

//动态规划法
class Solution1 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int length = prices.length;
		// dp[i][0]代表第i天持有股票的最大收益
		// dp[i][1]代表第i天不持有股票的最大收益
		int[][] dp = new int[length][2];
		int result = 0;
		dp[0][0] = -prices[0];
		dp[0][1] = 0;
		for (int i = 1; i < length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
			dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
		}
		return dp[length - 1][1];
	}
}