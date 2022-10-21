class Solution {
	public String longestPalindrome(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		int maxlength = 0;
		int beginindex = 0, endindex = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
//					������֧�ǲ��е�
					if (j - i <= 1) {
						dp[i][j] = true;
					} else if (dp[i + 1][j - 1]) {
						dp[i][j] = true;
					}
				}
//				���ǻ����Ҵ��������
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