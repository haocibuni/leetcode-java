//̰���㷨
class Solution1 {
	public int maxSubArray(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
//		�ܺ�
		int sum = Integer.MIN_VALUE;
//		��ǰ����
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i];
			sum = Math.max(sum, count); // ȡ�����ۼƵ����ֵ���൱�ڲ���ȷ�����������ֹλ�ã�
			if (count <= 0) {
				count = 0; // �൱���������������ʼλ�ã���Ϊ��������һ���������ܺ�
			}
		}
		return sum;
	}
}

//��̬�滮��
class Solution {
	public int maxSubArray(int[] nums) {
//		dp�����ʾi����ʱ���ĺ�
		int[] dp = new int[nums.length];
		int res = nums[0];
		dp[0] = nums[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//			��¼���ֵ
			res = res > dp[i] ? res : dp[i];
		}
		return res;
	}
}