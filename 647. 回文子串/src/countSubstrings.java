class Solution {
	public int countSubstrings(String s) {
//		dp数组，表示i-j是否 为回文串
		boolean[][] dp = new boolean[s.length()][s.length()];
//		回文子串数量
		int count = 0;
//		自低向上 自左到右
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
//					若相同，分为三种情况
					if (j - i <= 1) {
						dp[i][j] = true;
						count++;
					} else if (dp[i + 1][j - 1]) {
						dp[i][j] = true;
						count++;
					}
				}
			}
		}
		return count;
	}
}