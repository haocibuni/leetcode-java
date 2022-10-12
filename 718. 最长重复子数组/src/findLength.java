class Solution {
	public int findLength(int[] nums1, int[] nums2) {
		int res = 0;
//		dp���飬��ʾi-1�±��j-1�±������У�����״̬ת�Ʒ����趨
//		������Ϊ��������ȵĳ��ȣ����޷��ж����һ������
		int[][] dp = new int[nums1.length + 1][nums2.length + 1];
		for (int i = 1; i < nums1.length + 1; i++) {
			for (int j = 1; j < nums2.length + 1; j++) {
//				����������ȣ���״̬ת��
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
//					��¼���ֵ
					res = res > dp[i][j] ? res : dp[i][j];
				}

			}

		}
		return res;

	}
}