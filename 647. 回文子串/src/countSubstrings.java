class Solution {
	public int countSubstrings(String s) {
//		dp���飬��ʾi-j�Ƿ� Ϊ���Ĵ�
		boolean[][] dp = new boolean[s.length()][s.length()];
//		�����Ӵ�����
		int count = 0;
//		�Ե����� ������
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
//					����ͬ����Ϊ�������
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