//̰���㷨
class Solution {
	public int maxProfit(int[] prices) {
		int result = 0;
		int curDiff;
//		������Ĳ�ֵ����0����ӵ���������
		for (int i = 1; i < prices.length; i++) {
			curDiff = prices[i] - prices[i - 1];
			if (curDiff > 0) {
				result += curDiff;
			}
		}
		return result;

	}
}