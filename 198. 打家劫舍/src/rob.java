//动态规划法
class Solution {
	public int rob(int[] nums) {
//		如果数组为null或长度为0 就返回0
		if (nums == null || nums.length == 0)
			return 0;
//		如果数组长度为1 就返回nums[0]
		if (nums.length == 1)
			return nums[0];
//		dp数组，到i房屋最多偷到的金额
		int[] dp = new int[nums.length];
//		第一个状态为nums[0]
		dp[0] = nums[0];
//		第二个状态为nums[0]和nums[1]大的那个
		dp[1] = Math.max(dp[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
//			偷和不偷的金额那个比较大
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}
}