//贪心算法
class Solution1 {
	public int maxSubArray(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
//		总和
		int sum = Integer.MIN_VALUE;
//		当前计数
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i];
			sum = Math.max(sum, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
			if (count <= 0) {
				count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
			}
		}
		return sum;
	}
}

//动态规划法
class Solution {
	public int maxSubArray(int[] nums) {
//		dp数组表示i数字时最大的和
		int[] dp = new int[nums.length];
		int res = nums[0];
		dp[0] = nums[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//			记录最大值
			res = res > dp[i] ? res : dp[i];
		}
		return res;
	}
}