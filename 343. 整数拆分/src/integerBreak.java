//动态规划法
class Solution {
	public int integerBreak(int n) {
//		定义0-n的dp数组
		int[] dp = new int[n + 1];
//		2的最大乘积为1
		dp[2] = 1;
//		从3开始遍历
		for (int i = 3; i < dp.length; i++) {
//			比如10 则j属于1-9或2-8
			for (int j = 1; j <= i - j; j++) {
//				n由i-j和j组成 i-j可以为数或最大状态 在遍历过程中j都计算过不需要拆分，dp[i-j]为拆分i-j
				dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
			}
		}
		return dp[n];
	}
}