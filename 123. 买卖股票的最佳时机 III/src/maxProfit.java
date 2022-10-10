class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][5];
		dp[0][1] = -prices[0];
		dp[0][3] = -prices[0];
		for (int i = 1; i < dp.length; i++) {
//			第一次买入，要么前面已经买入，要么现在买
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//			第一次卖出，要么前面已经卖出，要么现在卖出
			dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
//			第二次买入，要么前面已经买入，要么现在买入
			dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
//			第二次卖出，要么前面已经卖出，要么现在卖出
			dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i]);
		}
//		返回最后卖出的收益
		return dp[n - 1][4];

	}
}