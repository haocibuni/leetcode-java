class Solution {
	public int maxProfit(int[] prices, int fee) {
//		买入价格+手续费
		int buy = prices[0] + fee;
//		盈利总和
		int sum = 0;
		for (int p : prices) {
//			如果买入价格+手续费小于以前，则从该点买入
			if (p + fee < buy) {
				buy = p + fee;
//			如果当前价格大于买入价格加手续费
			} else if (p > buy) {
//				则盈利为当前价格减去买入价格加手续费
				sum += p - buy;
//				买入价格为当前
				buy = p;
			}
		}
		return sum;
	}
}