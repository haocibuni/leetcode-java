//贪心算法
class Solution {
	public int maxProfit(int[] prices) {
		int result = 0;
		int curDiff;
//		若两天的插值大于0则添加到收益数组
		for (int i = 1; i < prices.length; i++) {
			curDiff = prices[i] - prices[i - 1];
			if (curDiff > 0) {
				result += curDiff;
			}
		}
		return result;

	}
}

//动态规划法
class Solution_dp {
	public int maxProfit(int[] prices) {
		// 实现1：二维数组存储
		// 可以将每天持有与否的情况分别用 dp[i][0] 和 dp[i][1] 来进行存储
		// 时间复杂度：O(n)，空间复杂度：O(n)
		int n = prices.length;
		// 创建二维数组存储状态
		int[][] dp = new int[n][2];
		// 初始状态
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
		}
		// 卖出股票收益高于持有股票收益，因此取[0]
		return dp[n - 1][0];
	}

}