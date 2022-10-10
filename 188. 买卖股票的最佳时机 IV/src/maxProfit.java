//动态规划法
class Solution {
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
//		奇数买 偶数卖
		int[][] dp = new int[n][2 * k + 1];
		for (int i = 1; i < 2 * k; i = i + 2) {
			dp[0][i] = -prices[0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 2 * k - 1; j = j + 2) {
				dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
				dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
			}

		}
//		返回最后卖出的收益
		return dp[n - 1][2 * k];
	}
}