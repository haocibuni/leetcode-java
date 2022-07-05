//���ξ�ֵ����ʽ+��+���ֵ������ ʱ�临�Ӷ�1 �ռ临�Ӷ�1
class Solution_extreme {
	public int cuttingRope(int n) {
		if (n <= 3) {
			return n - 1;
		}
		int a = n / 3, b = n % 3;
		if (b == 2) {
			return ((int) Math.pow(3, a)) * 2;
		}
		if (b == 1) {
			return ((int) Math.pow(3, a - 1)) * 4;
		}
		return (int) Math.pow(3, a);

	}
}

//��̬�滮�� ʱ�临�Ӷ�n2 ������� �� �����������
class Solution_dp {
	public int cuttingRope(int n) {
		/*
		 * dp�岿��: 1.״̬����:dp[i]Ϊ����Ϊi�����Ӽ���m�����˻�Ϊdp[i] 2.״̬ת��:dp[i]������;������ת�Ƶõ� 2.1
		 * ��ǰһ��dp[j]*(i-j)�õ�,��ǰ�����>=2��,�����ټ�һ��,��ʱ�ĳ˻�����>=3�� 2.2
		 * ǰ�浥����һ��,����ʣ�µĵ�����һ��,�˻�Ϊj*(i-j),�˻�����Ϊ2
		 * ���������ȡ���ֵ��Ϊdp[i]��ֵ,ͬʱӦ�ñ�������j,j��[1,i-1],ȡ���ֵ 3.��ʼ��:��ʼ��dp[1]=1���� 4.����˳��:��ȻΪ�������
		 * 5.��������:����dp[n]
		 */
		// ����dp����
		int[] dp = new int[n + 1];
		// ��ʼ��
		dp[1] = 1; // ָ����Ϊ1�ĵ����˻�Ϊ1
		// ����[2,n]��ÿ��״̬
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i - 1; j++) {
				// �������ת�����(�˻�����Ϊ2��2����)�����ֵ
				int tmp = Math.max(dp[j] * (i - j), j * (i - j));
				dp[i] = Math.max(tmp, dp[i]);
			}
		}
		return dp[n];
	}
}

class Solution {
	public int cuttingRope(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j <= i - 1; j++) {
				int temp = Math.max(dp[j] * (i - j), j * (i - j));
				dp[i] = Math.max(temp, dp[i]);
			}
		}
		return dp[n];
	}
}