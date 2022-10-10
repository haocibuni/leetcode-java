//r̰�ķ�
class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int min = prices[0];
		int[] dp = new int[prices.length];
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
//			��ȡ��Сֵ
			if (prices[i] < min) {
				min = prices[i];
			}
//			��ȡ���ֵ
			dp[i] = Math.max(prices[i] - min, dp[i - 1]);
		}
		return dp[prices.length - 1];
	}
}

//��̬�滮��
class Solution1 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int length = prices.length;
		// dp[i][0]�����i����й�Ʊ���������
		// dp[i][1]�����i�첻���й�Ʊ���������
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