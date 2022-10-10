//��̬�滮��
class Solution {
	public int rob(int[] nums) {
//		�������Ϊnull�򳤶�Ϊ0 �ͷ���0
		if (nums == null || nums.length == 0)
			return 0;
//		������鳤��Ϊ1 �ͷ���nums[0]
		if (nums.length == 1)
			return nums[0];
//		dp���飬��i�������͵���Ľ��
		int[] dp = new int[nums.length];
//		��һ��״̬Ϊnums[0]
		dp[0] = nums[0];
//		�ڶ���״̬Ϊnums[0]��nums[1]����Ǹ�
		dp[1] = Math.max(dp[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
//			͵�Ͳ�͵�Ľ���Ǹ��Ƚϴ�
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}
}