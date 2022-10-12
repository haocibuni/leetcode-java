import java.util.Arrays;

class Solution {
	public int lengthOfLIS(int[] nums) {
//		dp数组表示第i个数字 最长子序列的长度
		int[] dp = new int[nums.length];
//		初始状态应该都为1
		Arrays.fill(dp, 1);
//		定义结果最长长度 保存最大状态
		int res = Integer.MIN_VALUE;
//		遍历数字
		for (int i = 0; i < dp.length; i++) {
//			查看该数字之前的最长序列串
			for (int j = 0; j < i; j++) {
//				获取最长序列加1
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
//				跟其它序列比较
				if (dp[i] > res) {
					res = dp[i];
				}
			}
		}
		return res;

	}
}