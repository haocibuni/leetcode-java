class Solution {
	public String longestPalindrome(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		int maxlength = 0;
		int beginindex = 0, endindex = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
//					两个分支是并行的
					if (j - i <= 1) {
						dp[i][j] = true;
					} else if (dp[i + 1][j - 1]) {
						dp[i][j] = true;
					}
				}
//				若是回文且大于最长回文
				if (j - i + 1 > maxlength && dp[i][j] == true) {
					maxlength = j - i + 1;
					beginindex = i;
					endindex = j + 1;
				}
			}
		}
		return s.substring(beginindex, endindex);

	}
}