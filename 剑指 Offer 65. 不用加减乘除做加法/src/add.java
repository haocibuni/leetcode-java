//λ���㷨 ʱ�临�Ӷ�n �ռ临�Ӷ�1
//��λΪ������ �ǽ�λΪ�������
//��ֹ����Ϊ��λΪ0 ʱ ���طǽ�λ
class Solution {
	public int add(int a, int b) {
		while (b != 0) {
			int c = (a & b) << 1;
			a = a ^ b;
			b = c;
		}
		return a;

	}
}