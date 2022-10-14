class Solution {
	public int longestPalindromeSubseq(String s) {
//		dp数组，表示i-j的最长子串
		int[][] dp = new int[s.length()][s.length()];

//		自低向上 自左到右
		for (int i = s.length() - 1; i >= 0; i--) {
//			初始化对角线元素 即一个字符回文串长度肯定是1
			dp[i][i] = 1;
//			j从对角线上面开始遍历
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][s.length() - 1];
	}
}