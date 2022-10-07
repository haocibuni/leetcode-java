class Solution {
	public int findMaxForm(String[] strs, int m, int n) {
//		dp�����ʾm��0��n��1�ĸ���
		int[][] dp = new int[m + 1][n + 1];
		int oneSum, zeroSum;
//		�����ַ�������
		for (String str : strs) {
//			��ȡ���ַ���0��1������
			oneSum = 0;
			zeroSum = 0;
			char[] chars = str.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == '0') {
					zeroSum++;
				} else {
					oneSum++;
				}
			}
//			��ǰ�ĸ����໹����һ��״̬�ĸ�����
			for (int i = m; i >= zeroSum; i--) {
				for (int j = n; j >= oneSum; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i - zeroSum][j - oneSum] + 1);
				}

			}
		}
		return dp[m][n];
	}
}