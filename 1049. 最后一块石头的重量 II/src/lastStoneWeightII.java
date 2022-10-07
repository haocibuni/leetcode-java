//��̬�滮�� 01��������
class Solution {
	public int lastStoneWeightII(int[] stones) {
//		ʯͷ������
		int sum = 0;
		for (int i : stones) {
			sum += i;
		}
//		����֮һ���� ����ȡ��
		int target = sum / 2;
//		dp���飺����������jʱ�ܷŵ�������ߵ�����
		int[] dp = new int[target + 1];
		for (int i = 0; i < stones.length; i++) {
			for (int j = target; j >= stones[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
			}
		}
		return (sum - dp[target]) - dp[target];
	}
}