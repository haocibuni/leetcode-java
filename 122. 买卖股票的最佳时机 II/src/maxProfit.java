//̰���㷨
class Solution {
	public int maxProfit(int[] prices) {
		int result = 0;
		int curDiff;
//		������Ĳ�ֵ����0����ӵ���������
		for (int i = 1; i < prices.length; i++) {
			curDiff = prices[i] - prices[i - 1];
			if (curDiff > 0) {
				result += curDiff;
			}
		}
		return result;

	}
}

//��̬�滮��
class Solution_dp {
	public int maxProfit(int[] prices) {
		// ʵ��1����ά����洢
		// ���Խ�ÿ�������������ֱ��� dp[i][0] �� dp[i][1] �����д洢
		// ʱ�临�Ӷȣ�O(n)���ռ临�Ӷȣ�O(n)
		int n = prices.length;
		// ������ά����洢״̬
		int[][] dp = new int[n][2];
		// ��ʼ״̬
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
		}
		// ������Ʊ������ڳ��й�Ʊ���棬���ȡ[0]
		return dp[n - 1][0];
	}

}