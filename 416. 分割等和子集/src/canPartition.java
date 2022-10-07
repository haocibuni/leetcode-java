//动态规划 利用01背包问题解决
class Solution {
	public boolean canPartition(int[] nums) {
//		若数组为空则不能划分
		if (nums == null || nums.length == 0) {
			return false;
		}
//		数组长度
		int n = nums.length;
//		数组总和
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
//		若数组总和为奇数则无法划分为两个子集
		if (sum % 2 != 0) {
			return false;
		}
//		背包大小
		int target = sum / 2;
//		dp数组
		int[] dp = new int[target + 1];
//		0-n表示物品下标
		for (int i = 0; i < n; i++) {
//			target-num[i]表示重量
			for (int j = target; j >= nums[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
			}
		}
		return dp[target] == target;

	}
}