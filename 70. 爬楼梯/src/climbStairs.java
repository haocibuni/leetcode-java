class Solution_dp {
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int a = 1, b = 2, c = 0;
		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
}

class Solution {
	public int climbStairs(int n) {
//		定义背包容量的dp数组，表示爬到i阶台阶的楼顶由dp[i]种方法
		int[] dp = new int[n + 1];
//		累加需要设dp[0]为1
		dp[0] = 1;
//		物品重量
		int[] weight = { 1, 2 };
//		先遍历背包容量
		for (int i = 0; i <= n; i++) {
//			再遍历物品重量
			for (int j = 0; j < weight.length; j++) {
//				若当前背包容量大于物品重量，则加上没装此物品时的方法
				if (i >= weight[j]) {
					dp[i] += dp[i - weight[j]];
				}
			}
		}
		return dp[n];
	}
}