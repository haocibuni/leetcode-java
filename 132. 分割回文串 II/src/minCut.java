class Solution {
	public int minCut(String s) {
//		判断i-j是否为回文
		boolean[][] dp = new boolean[s.length()][s.length()];
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
			}
		}
//		判断到i切割几次
		int[] cut = new int[s.length()];
//		最大切割次数
		for (int i = 0; i < cut.length; i++) {
			cut[i] = i;
		}
//		找0-i中间的最小切割
		for (int i = 0; i < cut.length; i++) {
			if (dp[0][i]) {
				cut[i] = 0;
				continue;
			}
			for (int j = 0; j < i; j++) {
				if (dp[j + 1][i]) {
					cut[i] = Math.min(cut[i], cut[j] + 1);
				}
			}
		}
		return cut[s.length() - 1];
	}
}