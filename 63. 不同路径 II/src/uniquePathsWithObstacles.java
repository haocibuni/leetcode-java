//��̬�滮��
class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
//		dp����
		int[][] dp = new int[m][n];
//		�������յ㶼���ϰ��򷵻�0
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}
//		��ʼ����һ�к͵�һ��
		for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++) {
			dp[0][i] = 1;
		}
//		״̬ת��
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