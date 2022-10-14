//子串自顶向下
class Solution {
	public int numDistinct(String s, String t) {
//		以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
		int[][] dp = new int[s.length() + 1][t.length() + 1];
//		因为也就是把以i-1为结尾的s，删除所有元素，出现空字符串的个数就是1。
		for (int i = 0; i < s.length() + 1; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < t.length() + 1; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
//					当第i与j字符匹配，则需要去除这俩的个数加去除i的个数
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
//					若不匹配则使用去除i的状态
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
//		返回最后状态
		return dp[s.length()][t.length()];
	}
}