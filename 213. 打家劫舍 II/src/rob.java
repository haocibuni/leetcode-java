class Solution {
	public int rob(int[] nums) {
//		如果数组为null或长度为0 就返回0
		if (nums == null || nums.length == 0)
			return 0;
//		如果数组长度为1 就返回nums[0]
		if (nums.length == 1)
			return nums[0];
//		不偷第一家
		int rob1 = robhelp(nums, 1, nums.length - 1);
//		不偷最后一家
		int rob2 = robhelp(nums, 0, nums.length - 2);
		return Math.max(rob1, rob2);
	}

	public int robhelp(int[] nums, int start, int end) {
//		若起始终止下标相等 直接返回
		if (start == end) {
			return nums[start];
		}
//		dp数组，到i房屋最多偷到的金额
		int[] dp = new int[nums.length];
//		第一个状态为nums[0]
		dp[start] = nums[start];
//		第二个状态为nums[0]和nums[1]大的那个
		dp[start + 1] = Math.max(dp[start], nums[start + 1]);
		for (int i = start + 2; i <= end; i++) {
//			偷和不偷的金额那个比较大
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[end];
	}
}