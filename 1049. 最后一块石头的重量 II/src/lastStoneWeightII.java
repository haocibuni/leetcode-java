//动态规划法 01背包问题
class Solution {
	public int lastStoneWeightII(int[] stones) {
//		石头重量和
		int sum = 0;
		for (int i : stones) {
			sum += i;
		}
//		二分之一重量 向下取整
		int target = sum / 2;
//		dp数组：当背包称重j时能放的重量最高的数组
		int[] dp = new int[target + 1];
		for (int i = 0; i < stones.length; i++) {
			for (int j = target; j >= stones[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
			}
		}
		return (sum - dp[target]) - dp[target];
	}
}