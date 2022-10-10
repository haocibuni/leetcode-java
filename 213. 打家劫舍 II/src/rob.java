class Solution {
	public int rob(int[] nums) {
//		�������Ϊnull�򳤶�Ϊ0 �ͷ���0
		if (nums == null || nums.length == 0)
			return 0;
//		������鳤��Ϊ1 �ͷ���nums[0]
		if (nums.length == 1)
			return nums[0];
//		��͵��һ��
		int rob1 = robhelp(nums, 1, nums.length - 1);
//		��͵���һ��
		int rob2 = robhelp(nums, 0, nums.length - 2);
		return Math.max(rob1, rob2);
	}

	public int robhelp(int[] nums, int start, int end) {
//		����ʼ��ֹ�±���� ֱ�ӷ���
		if (start == end) {
			return nums[start];
		}
//		dp���飬��i�������͵���Ľ��
		int[] dp = new int[nums.length];
//		��һ��״̬Ϊnums[0]
		dp[start] = nums[start];
//		�ڶ���״̬Ϊnums[0]��nums[1]����Ǹ�
		dp[start + 1] = Math.max(dp[start], nums[start + 1]);
		for (int i = start + 2; i <= end; i++) {
//			͵�Ͳ�͵�Ľ���Ǹ��Ƚϴ�
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[end];
	}
}