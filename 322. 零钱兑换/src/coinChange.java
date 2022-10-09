class Solution {
	public int coinChange(int[] coins, int amount) {
//		dp���� ��ʾ�����ܶ�j����Ҫ�����ٵ�Ӳ����
		int[] dp = new int[amount + 1];
//		����ѳ�ʼֵ���ǣ���dp0�Ժ�ֵΪmax
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = max;
		}
//		�����ܽ��0����Ľ�Ҹ���Ϊ0
		dp[0] = 0;
//		��Ʒ���⣬��������
		for (int i = 0; i < coins.length; i++) {
//			�ӵ�ǰ��Ʒ������������������
			for (int j = coins[i]; j <= amount; j++) {
//				����������ȥ��ǰ��Ʒ����
//				ֻ��dp[j-coins[i]]���ǳ�ʼ���ֵʱ����λ����ѡ��ı�Ҫ
				if (dp[j - coins[i]] != max) {
//					���ϵ�ǰ��Ʒ���ɵ���j�ܶ�
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}
		return dp[amount] == max ? -1 : dp[amount];

	}
}