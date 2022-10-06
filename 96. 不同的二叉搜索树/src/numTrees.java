class Solution {
	public int numTrees(int n) {
//		定义0-n的dp数组
		int[] dp = new int[n + 1];
//		设dp0为1才能乘
		dp[0] = 1;
//		
		for (int i = 0; i < n + 1; i++) {
			for (int j = 1; j <= i; j++) {
//				左子树乘右子树乘积累加
//				要想算i必须计算出前面的数字
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}
}