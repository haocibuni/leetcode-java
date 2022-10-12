class Solution {
	public int findLengthOfLCIS(int[] nums) {
//		a��ʾdp[i-1] b��ʾdp[i] res��ʾ��¼�����ֵ
		int a = 1, b = 1, res = 1;
//		��������
		for (int i = 1; i < nums.length; i++) {
//			��nums[i] > nums[i - 1]�� dp[i]=dp[i-1]+1
			if (nums[i] > nums[i - 1]) {
				b = a + 1;
			}
//			��¼�����
			res = res >= b ? res : b;
//			״̬ת��
			a = b;
			b = 1;

		}
		return res;
	}
}