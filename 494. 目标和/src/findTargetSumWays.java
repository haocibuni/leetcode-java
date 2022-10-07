class Solution {
	public int findTargetSumWays(int[] nums, int target) {
//		定义数组总和
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
//		若总和加目标为奇数则返回0，无法使奇数和为0
		if ((target + sum) % 2 != 0)
			return 0;
//		能装多少正数
		int size = (target + sum) / 2;
		if (size < 0) {
			size = -size;
		}
//		dp数组 表示装n个正数的方法数
		int[] dp = new int[size + 1];
//		设初始状态为1
		dp[0] = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = size; j >= nums[i]; j--) {
				dp[j] += dp[j - nums[i]];
			}
		}
		return dp[size];

	}
}