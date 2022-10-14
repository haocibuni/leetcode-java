class Solution {
	public int minDistance(String word1, String word2) {
//		����dp�����ʾ��Ҫ�ﵽ�������Ҫɾ����Ԫ�ظ���
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//		i�����ַ�������ַ�����Ҫɾ��i��
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
//		j�����ַ�������ַ�����Ҫɾ��j��
		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = j;
		}
//		�����ǿ��ַ���
		for (int i = 1; i < word1.length() + 1; i++) {
			for (int j = 1; j < word2.length() + 1; j++) {
//				i-1��j-1��ʾ��ǰ״̬�µ���ĸ
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//					������򰴲�������ǰ����ĸ��ʱ��Ĵ���
					dp[i][j] = dp[i - 1][j - 1];
				} else {
//					������ȣ�����ɾ��word1һ���ַ���ɾ��word2һ���ַ���ɾ��word1��2�������ַ�
					dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
				}
			}
		}
		return dp[word1.length()][word2.length()];

	}
}