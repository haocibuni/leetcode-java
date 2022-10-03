//̰���㷨
class Solution {
	public int candy(int[] ratings) {
//		��������
		int[] candyVec = new int[ratings.length];
//		Ĭ�ϸ���һ��һ���ǹ�
		candyVec[0] = 1;
//		�������ұ���
		for (int i = 1; i < ratings.length; i++) {
//			����ǰ������һ���÷֣������һ����һ���ǹ��������1��
			candyVec[i] = (ratings[i] > ratings[i - 1]) ? candyVec[i - 1] + 1 : 1;

		}
//		�����������
		for (int i = ratings.length - 2; i >= 0; i--) {
//			�����ǰ������һ���÷�
			if (ratings[i] > ratings[i + 1]) {
//				��ѡȡ��һ�θ�ֵ����һ���÷ּ�һ�����ֵ
				candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
			}
		}
//		�ۼ�
		int result = 0;
		for (int num : candyVec) {
			result += num;
		}
		return result;

	}
}