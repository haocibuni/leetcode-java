class Solution {
	public int findLength(int[] nums1, int[] nums2) {
		int res = 0;
//		dp数组，表示i-1下标和j-1下标的最长序列，根据状态转移方程设定
//		若设置为跟数组相等的长度，则无法判断最后一个整数
		int[][] dp = new int[nums1.length + 1][nums2.length + 1];
		for (int i = 1; i < nums1.length + 1; i++) {
			for (int j = 1; j < nums2.length + 1; j++) {
//				若两正数相等，则状态转移
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
//					记录最大值
					res = res > dp[i][j] ? res : dp[i][j];
				}

			}

		}
		return res;

	}
}