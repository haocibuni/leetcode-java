class Solution {
	public int maxProfit(int[] prices, int fee) {
//		����۸�+������
		int buy = prices[0] + fee;
//		ӯ���ܺ�
		int sum = 0;
		for (int p : prices) {
//			�������۸�+������С����ǰ����Ӹõ�����
			if (p + fee < buy) {
				buy = p + fee;
//			�����ǰ�۸��������۸��������
			} else if (p > buy) {
//				��ӯ��Ϊ��ǰ�۸��ȥ����۸��������
				sum += p - buy;
//				����۸�Ϊ��ǰ
				buy = p;
			}
		}
		return sum;
	}
}