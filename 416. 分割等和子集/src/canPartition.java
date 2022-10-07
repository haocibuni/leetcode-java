//��̬�滮 ����01����������
class Solution {
	public boolean canPartition(int[] nums) {
//		������Ϊ�����ܻ���
		if (nums == null || nums.length == 0) {
			return false;
		}
//		���鳤��
		int n = nums.length;
//		�����ܺ�
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
//		�������ܺ�Ϊ�������޷�����Ϊ�����Ӽ�
		if (sum % 2 != 0) {
			return false;
		}
//		������С
		int target = sum / 2;
//		dp����
		int[] dp = new int[target + 1];
//		0-n��ʾ��Ʒ�±�
		for (int i = 0; i < n; i++) {
//			target-num[i]��ʾ����
			for (int j = target; j >= nums[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
			}
		}
		return dp[target] == target;

	}
}