import java.util.Arrays;

class Solution {
	public int lengthOfLIS(int[] nums) {
//		dp�����ʾ��i������ ������еĳ���
		int[] dp = new int[nums.length];
//		��ʼ״̬Ӧ�ö�Ϊ1
		Arrays.fill(dp, 1);
//		����������� �������״̬
		int res = Integer.MIN_VALUE;
//		��������
		for (int i = 0; i < dp.length; i++) {
//			�鿴������֮ǰ������д�
			for (int j = 0; j < i; j++) {
//				��ȡ����м�1
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
//				���������бȽ�
				if (dp[i] > res) {
					res = dp[i];
				}
			}
		}
		return res;

	}
}