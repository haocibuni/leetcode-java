//��ʼ����+��λ�� ʱ�临�Ӷ�logn �ռ临�Ӷ�logn
//������λ������ͨ��whileѭ��ȷ����λ���ڵ�λ������ʼ����
//Ȼ��ȷ��������λ������
//���ȷ����λ�����ֵ���һλ
//  ��ѧ
//           ���ַ�Χ   λ��   ��������   ��λ����
//            1 - 9      1        9          9
//           10 - 99     2        90         180
//          100 - 999    3        900        2700
//             ...      ...       ...        ...
//        start - end   digit    9*start   9*start*dight

class Solution {
	public int findNthDigit(int n) {
		int digit = 1;
//		����λ�ܺͺ���λ����ʼ������long
		long start = 1;
		long count = 9;
		while (n > count) {
//			long��int���
			n -= count;
			start = start * 10;
			digit = digit + 1;
			count = 9 * start * digit;
		}
		long num = start + (n - 1) / digit;
//		��longת��λstring
		String string = Long.toString(num);
//		��stringת��λint
		return string.charAt((n - 1) % digit) - '0';
	}
}