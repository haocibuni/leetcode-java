class Solution_dp {
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int a = 1, b = 2, c = 0;
		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
}

class Solution {
	public int climbStairs(int n) {
//		���屳��������dp���飬��ʾ����i��̨�׵�¥����dp[i]�ַ���
		int[] dp = new int[n + 1];
//		�ۼ���Ҫ��dp[0]Ϊ1
		dp[0] = 1;
//		��Ʒ����
		int[] weight = { 1, 2 };
//		�ȱ�����������
		for (int i = 0; i <= n; i++) {
//			�ٱ�����Ʒ����
			for (int j = 0; j < weight.length; j++) {
//				����ǰ��������������Ʒ�����������ûװ����Ʒʱ�ķ���
				if (i >= weight[j]) {
					dp[i] += dp[i - weight[j]];
				}
			}
		}
		return dp[n];
	}
}