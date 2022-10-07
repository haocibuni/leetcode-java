class Solution {
	public int findMaxForm(String[] strs, int m, int n) {
//		dp数组表示m个0和n个1的个数
		int[][] dp = new int[m + 1][n + 1];
		int oneSum, zeroSum;
//		遍历字符串数组
		for (String str : strs) {
//			获取各字符串0和1的数量
			oneSum = 0;
			zeroSum = 0;
			char[] chars = str.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == '0') {
					zeroSum++;
				} else {
					oneSum++;
				}
			}
//			当前的个数多还是上一个状态的个数多
			for (int i = m; i >= zeroSum; i--) {
				for (int j = n; j >= oneSum; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i - zeroSum][j - oneSum] + 1);
				}

			}
		}
		return dp[m][n];
	}
}