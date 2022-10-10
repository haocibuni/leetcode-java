class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][5];
		dp[0][1] = -prices[0];
		dp[0][3] = -prices[0];
		for (int i = 1; i < dp.length; i++) {
//			��һ�����룬Ҫôǰ���Ѿ����룬Ҫô������
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//			��һ��������Ҫôǰ���Ѿ�������Ҫô��������
			dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
//			�ڶ������룬Ҫôǰ���Ѿ����룬Ҫô��������
			dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
//			�ڶ���������Ҫôǰ���Ѿ�������Ҫô��������
			dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i]);
		}
//		�����������������
		return dp[n - 1][4];

	}
}