class Solution {
	public int minCut(String s) {
//		�ж�i-j�Ƿ�Ϊ����
		boolean[][] dp = new boolean[s.length()][s.length()];
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
			}
		}
//		�жϵ�i�и��
		int[] cut = new int[s.length()];
//		����и����
		for (int i = 0; i < cut.length; i++) {
			cut[i] = i;
		}
//		��0-i�м����С�и�
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