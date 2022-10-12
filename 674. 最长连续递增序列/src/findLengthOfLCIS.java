class Solution {
	public int findLengthOfLCIS(int[] nums) {
//		a表示dp[i-1] b表示dp[i] res表示记录的最大值
		int a = 1, b = 1, res = 1;
//		遍历序列
		for (int i = 1; i < nums.length; i++) {
//			若nums[i] > nums[i - 1]则 dp[i]=dp[i-1]+1
			if (nums[i] > nums[i - 1]) {
				b = a + 1;
			}
//			记录最大结果
			res = res >= b ? res : b;
//			状态转换
			a = b;
			b = 1;

		}
		return res;
	}
}