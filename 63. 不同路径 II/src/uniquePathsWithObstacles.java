//动态规划法
class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
//		dp数组
		int[][] dp = new int[m][n];
//		若起点和终点都有障碍则返回0
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}
//		初始化第一行和第一列
		for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++) {
			dp[0][i] = 1;
		}
//		状态转移
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}