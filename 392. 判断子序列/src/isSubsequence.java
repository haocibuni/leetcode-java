//此题可根据最大公共序列解
class Solution {
	public boolean isSubsequence(String s, String t) {
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < t.length() + 1; j++) {
				if (sChars[i - 1] == tChars[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
//					此处错误
					dp[i][j] = dp[i][j - 1];
				}

			}
		}
		return dp[s.length()][t.length()] == s.length();
	}
}