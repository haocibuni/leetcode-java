//动态规划法
class Solution {
	public int uniquePaths(int m, int n) {
//		动态规划数组
		int[][] dp = new int[m][n];
//		起始点定义
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
//		状态转移
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
//		返回最后状态
		return dp[m - 1][n - 1];

	}
}