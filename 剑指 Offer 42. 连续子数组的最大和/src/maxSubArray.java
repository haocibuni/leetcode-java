//动态规划法 时间复杂度n 空间复杂度1
//dp[i]表示以num[i]结尾的最大和
//若dp[i-1]小于等于0 则重新开始
//若dp[i-1]大于0 则加上当前的数
//选取最大的值
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