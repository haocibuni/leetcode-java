//本题和动态规划：718. 最长重复子数组区别在于这里不要求是连续的,
//连续的话若不相等则初始化为0 不连续则从以前的两个状态取最大值
//不连续的能保存最大状态
class Solution {
	public int longestCommonSubsequence(String text1, String text2) {

		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		char[] text1Chars = text1.toCharArray();
		char[] text2Chars = text2.toCharArray();
		for (int i = 1; i < text1Chars.length + 1; i++) {
			for (int j = 1; j < text2Chars.length + 1; j++) {
				if (text1Chars[i - 1] == text2Chars[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}
		}
		return dp[text1.length()][text2.length()];
	}
}