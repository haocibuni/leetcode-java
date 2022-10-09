class Solution {
	public int numSquares(int n) {
//		��Ϊj����ȫƽ��������С������dp����
		int[] dp = new int[n + 1];
//		��ʼֵ��Ϊ���ֵ�����ⱻ����
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = max;
		}
//		��ʾ��Ϊ0����ȫƽ��������С����
		dp[0] = 0;
//		�����Ʒ
		for (int i = 0; i * i < dp.length; i++) {
//			�ڲ㱳��
			for (int j = i * i; j <= n; j++) {
//				����ȥ��ȫƽ������������С�����ǳ�ʼֵ������
				if (dp[j - i * i] != max) {
					dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
				}
			}
		}
		return dp[n];
	}

}