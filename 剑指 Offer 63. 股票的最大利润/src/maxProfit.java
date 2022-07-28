//������ ʱ�临�Ӷ�n2 �ռ临�Ӷ�1
class Solution_force {
	public int maxProfit(int[] prices) {
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] - prices[i] > 0 && prices[j] - prices[i] > max) {
					max = prices[j] - prices[i];
				}
			}
		}
		return max;
	}
}

//��̬�滮�� ʱ�临�Ӷ�n �ռ临�Ӷ�1
class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int min = prices[0];
		int dp = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			}
			dp = Math.max(dp, prices[i] - min);
		}
		return dp;

	}
}