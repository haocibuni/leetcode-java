//��̬�滮�� ʱ�临�Ӷ�n �ռ临�Ӷ�1
//dp[i]��ʾ��num[i]��β������
//��dp[i-1]С�ڵ���0 �����¿�ʼ
//��dp[i-1]����0 ����ϵ�ǰ����
//ѡȡ����ֵ
class Solution_dp {
	public int maxSubArray(int[] nums) {
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + Math.max(nums[i - 1], 0);
			res = Math.max(nums[i], res);
		}
		return res;
	}
}

class Solution {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int j = 1; j < nums.length; j++) {
			if (dp[j - 1] > 0) {
				dp[j] = dp[j - 1] + nums[j];
			} else {
				dp[j] = nums[j];
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > max)
				max = dp[i];
		}
		return max;
	}
}
