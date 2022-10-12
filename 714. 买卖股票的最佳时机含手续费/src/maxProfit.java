class Solution1 {
	public int maxProfit(int[] prices, int fee) {
//		����۸�+������
		int buy = prices[0] + fee;
//		ӯ���ܺ�
		int sum = 0;
		for (int p : prices) {
//			�������۸�+������С����ǰ����Ӹõ�����
			if (p + fee < buy) {
				buy = p + fee;
//			�����ǰ�۸��������۸��������
			} else if (p > buy) {
//				��ӯ��Ϊ��ǰ�۸��ȥ����۸��������
				sum += p - buy;
//				����۸�Ϊ��ǰ
				buy = p;
			}
		}
		return sum;
	}
}

class Solution {
	public int maxProfit(int[] prices, int fee) {
//		����dp���飬��ʾ��i�� ���иù�Ʊ�Ͳ����иù�Ʊ���������
		int[][] dp = new int[prices.length][2];
//		�����1����е�һ֧��Ʊ���������һֱ��Ʊ�������
		dp[0][0] = -prices[0];
		for (int i = 1; i < dp.length; i++) {
//			��i����б�ʾ��i-1����л򲻳���Ȼ����i�����
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
//			��i�첻���б�ʾ��i-1�첻���У�����i-1�����i������
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
		}
//		�������һ������ֵ
		return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
	}
}