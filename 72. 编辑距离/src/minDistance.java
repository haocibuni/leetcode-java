class Solution {
	public int minDistance(String word1, String word2) {
//		定义dp数组表示想要达到相等最少要操作的元素个数
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//		i长度字符串与空字符串需要删除i次
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
//		j长度字符串与空字符串需要删除j次
		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = j;
		}
//		遍历非空字符串
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//					若相等则按不包括当前两字母的时候的次数
					dp[i][j] = dp[i - 1][j - 1];
				} else {
//					若不相等，则在删除word1一个字符或删除word2一个字符或替换word1及2的两个字符其中一个
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
}