//��̬�滮�� ʱ�临�Ӷ�n �ռ临�Ӷ�1
//dp[i]��ʾ��num[i]��β������
//��dp[i-1]С�ڵ���0 �����¿�ʼ
//��dp[i-1]����0 ����ϵ�ǰ����
//ѡȡ����ֵ
class Solution {
	public int maxSubArray(int[] nums) {
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + Math.max(nums[i - 1], 0);
			res = Math.max(nums[i], res);
		}
		return res;
	}
}