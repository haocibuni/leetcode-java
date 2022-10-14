//�Ӵ��Զ�����
class Solution {
	public int numDistinct(String s, String t) {
//		��i-1Ϊ��β��s�������г�����j-1Ϊ��β��t�ĸ���Ϊdp[i][j]��
		int[][] dp = new int[s.length() + 1][t.length() + 1];
//		��ΪҲ���ǰ���i-1Ϊ��β��s��ɾ������Ԫ�أ����ֿ��ַ����ĸ�������1��
		for (int i = 0; i < s.length() + 1; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < t.length() + 1; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
//					����i��j�ַ�ƥ�䣬����Ҫȥ�������ĸ�����ȥ��i�ĸ���
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
//					����ƥ����ʹ��ȥ��i��״̬
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
//		�������״̬
		return dp[s.length()][t.length()];
	}
}