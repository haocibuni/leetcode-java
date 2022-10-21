class Solution {
	public int findNumberOfLIS(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
//		总长为i，最长递增数列的长度
		int[] dp = new int[nums.length];
//		以nums[i]结尾，最长递增数列的个数
		int[] count = new int[nums.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		for (int i = 0; i < count.length; i++) {
			count[i] = 1;
		}
		int maxlength = 0;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
//					若大于则长度边长，i结尾的数列个数为count[j]
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						count[i] = count[j];
//					若相等则数量加
					} else if (dp[i] == dp[j] + 1) {
						count[i] += count[j];
					}
				}
				if (dp[i] > maxlength) {
					maxlength = dp[i];
				}
			}
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (dp[i] == maxlength) {
				res = res + count[i];
			}
		}
		return res;

	}
}