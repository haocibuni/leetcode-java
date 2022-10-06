class Solution {
	public int numTrees(int n) {
//		����0-n��dp����
		int[] dp = new int[n + 1];
//		��dp0Ϊ1���ܳ�
		dp[0] = 1;
//		
		for (int i = 0; i < n + 1; i++) {
			for (int j = 1; j <= i; j++) {
//				���������������˻��ۼ�
//				Ҫ����i��������ǰ�������
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}
}