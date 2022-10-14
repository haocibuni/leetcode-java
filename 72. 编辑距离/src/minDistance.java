class Solution {
	public int minDistance(String word1, String word2) {
//		����dp�����ʾ��Ҫ�ﵽ�������Ҫ������Ԫ�ظ���
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
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//					������򰴲�������ǰ����ĸ��ʱ��Ĵ���
					dp[i][j] = dp[i - 1][j - 1];
				} else {
//					������ȣ�����ɾ��word1һ���ַ���ɾ��word2һ���ַ����滻word1��2�������ַ�����һ��
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
}