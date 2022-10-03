//贪心算法
class Solution {
	public int maxProfit(int[] prices) {
		int result = 0;
		int curDiff;
//		若两天的插值大于0则添加到收益数组
		for (int i = 1; i < prices.length; i++) {
			curDiff = prices[i] - prices[i - 1];
			if (curDiff > 0) {
				result += curDiff;
			}
		}
		return result;

	}
}