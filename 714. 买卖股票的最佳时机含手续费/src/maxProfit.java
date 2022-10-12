class Solution1 {
	public int maxProfit(int[] prices, int fee) {
//		买入价格+手续费
		int buy = prices[0] + fee;
//		盈利总和
		int sum = 0;
		for (int p : prices) {
//			如果买入价格+手续费小于以前，则从该点买入
			if (p + fee < buy) {
				buy = p + fee;
//			如果当前价格大于买入价格加手续费
			} else if (p > buy) {
//				则盈利为当前价格减去买入价格加手续费
				sum += p - buy;
//				买入价格为当前
				buy = p;
			}
		}
		return sum;
	}
}

class Solution {
	public int maxProfit(int[] prices, int fee) {
//		定义dp数组，表示第i天 持有该股票和不持有该股票的最大收益
		int[][] dp = new int[prices.length][2];
//		定义第1天持有第一支股票，即买入第一直股票后的收益
		dp[0][0] = -prices[0];
		for (int i = 1; i < dp.length; i++) {
//			第i天持有表示第i-1天持有或不持有然后在i天买的
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
//			第i天不持有表示第i-1天不持有，或在i-1天持有i天卖的
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
		}
//		返回最后一天的最大值
		return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
	}
}