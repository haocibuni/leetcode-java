class Solution {
	public int numSquares(int n) {
//		和为j的完全平方数的最小数量的dp数组
		int[] dp = new int[n + 1];
//		初始值设为最大值，避免被覆盖
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = max;
		}
//		表示和为0的完全平方数的最小数量
		dp[0] = 0;
//		外层物品
		for (int i = 0; i * i < dp.length; i++) {
//			内层背包
			for (int j = i * i; j <= n; j++) {
//				若减去完全平方数的数的最小数量是初始值则跳过
				if (dp[j - i * i] != max) {
					dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
				}
			}
		}
		return dp[n];
	}

}