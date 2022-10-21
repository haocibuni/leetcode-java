class Solution {
	public int findNumberOfLIS(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
//		�ܳ�Ϊi����������еĳ���
		int[] dp = new int[nums.length];
//		��nums[i]��β����������еĸ���
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
//					�������򳤶ȱ߳���i��β�����и���Ϊcount[j]
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						count[i] = count[j];
//					�������������
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