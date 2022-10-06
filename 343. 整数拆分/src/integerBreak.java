//��̬�滮��
class Solution {
	public int integerBreak(int n) {
//		����0-n��dp����
		int[] dp = new int[n + 1];
//		2�����˻�Ϊ1
		dp[2] = 1;
//		��3��ʼ����
		for (int i = 3; i < dp.length; i++) {
//			����10 ��j����1-9��2-8
			for (int j = 1; j <= i - j; j++) {
//				n��i-j��j��� i-j����Ϊ�������״̬ �ڱ���������j�����������Ҫ��֣�dp[i-j]Ϊ���i-j
				dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
			}
		}
		return dp[n];
	}
}