import java.util.ArrayList;

//�������ڷ� ʱ�临�Ӷ�n �ռ临�Ӷ�1
//����ʼ�߽�i ��߽�j
//��Ŀ��ֵС��sum���ұ߽�����
//��Ŀ��ֵ����sum����߽�����
//��Ŀ��ֵ����sum����i- j-1�������뵽��ʱ���飬������ʱ������ӵ�arraylist����
//���ұ߽紦��Ŀ��ֵ�е�ʱ�˳�ѭ������Ϊ�е�ֵ�������ұߵ�ֵ�������Ŀ��ֵ
class Solution {
	public int[][] findContinuousSequence(int target) {
		int i = 1, j = 1, sum = 0;
		ArrayList<int[]> res = new ArrayList<>();
		while (i <= target / 2) {
			if (sum < target) {
				sum = sum + j;
				j++;

			} else if (sum > target) {
				sum = sum - i;
				i++;
			} else {
				int[] temp = new int[j - i];
				for (int k = i; k < j; k++) {
					temp[k - i] = k;
				}
				res.add(temp);
				sum = sum - i;
				i++;
			}
		}
		return res.toArray(new int[res.size()][]);

	}
}