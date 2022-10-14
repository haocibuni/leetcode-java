class Solution {
	public int longestPalindromeSubseq(String s) {
//		dp���飬��ʾi-j����Ӵ�
		int[][] dp = new int[s.length()][s.length()];

//		�Ե����� ������
		for (int i = s.length() - 1; i >= 0; i--) {
//			��ʼ���Խ���Ԫ�� ��һ���ַ����Ĵ����ȿ϶���1
			dp[i][i] = 1;
//			j�ӶԽ������濪ʼ����
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