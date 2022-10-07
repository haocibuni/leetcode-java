class Solution {
	public int findTargetSumWays(int[] nums, int target) {
//		���������ܺ�
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
//		���ܺͼ�Ŀ��Ϊ�����򷵻�0���޷�ʹ������Ϊ0
		if ((target + sum) % 2 != 0)
			return 0;
//		��װ��������
		int size = (target + sum) / 2;
		if (size < 0) {
			size = -size;
		}
//		dp���� ��ʾװn�������ķ�����
		int[] dp = new int[size + 1];
//		���ʼ״̬Ϊ1
		dp[0] = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = size; j >= nums[i]; j--) {
				dp[j] += dp[j - nums[i]];
			}
		}
		return dp[size];

	}
}