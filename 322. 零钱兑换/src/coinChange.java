class Solution {
	public int coinChange(int[] coins, int amount) {
//		dp数组 表示凑足总额j所需要的最少的硬币数
		int[] dp = new int[amount + 1];
//		避免把初始值覆盖，将dp0以后赋值为max
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = max;
		}
//		凑足总金额0所需的金币个数为0
		dp[0] = 0;
//		物品在外，背包在内
		for (int i = 0; i < coins.length; i++) {
//			从当前物品重量遍历到背包重量
			for (int j = coins[i]; j <= amount; j++) {
//				背包重量减去当前物品重量
//				只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
				if (dp[j - coins[i]] != max) {
//					加上当前物品即可到达j总额
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}
		return dp[amount] == max ? -1 : dp[amount];

	}
}