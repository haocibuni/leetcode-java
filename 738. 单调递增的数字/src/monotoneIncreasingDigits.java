//̰���㷨 �Ӻ���ǰ
class Solution {
	public int monotoneIncreasingDigits(int n) {
//		������ת��Ϊ�ַ���
		String s = String.valueOf(n);
//		���ַ���ת��Ϊ�ַ�����
		char[] chars = s.toCharArray();
//		��ʼ�����9���±�
		int start = s.length();
//		�ӵ����ڶ�λ��ʼ����
		for (int i = s.length() - 2; i >= 0; i--) {
//			�����ǰ�ַ�������һ���ַ������1��������9���±���Ϊ��һλ
			if (chars[i] > chars[i + 1]) {
				chars[i]--;
				start = i + 1;
			}
		}
//		���9
		for (int i = start; i < chars.length; i++) {
			chars[i] = '9';
		}
//		���ַ�����ת��Ϊ�ַ������ٽ��ַ���תΪ����
		return Integer.parseInt(String.valueOf(chars));

	}
}