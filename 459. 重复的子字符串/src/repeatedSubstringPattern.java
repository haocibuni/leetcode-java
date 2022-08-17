//�ƶ�ƥ�䷨ ʱ�临�Ӷ�mn �ռ临�Ӷ�2n
//��ͷȥβ
class Solution {
	public boolean repeatedSubstringPattern(String s) {
		String newString = s + s;
		return newString.substring(1, newString.length() - 1).contains(s);

	}
}

//KMP��
class Solution_next {
	public boolean repeatedSubstringPattern(String s) {
//    	���ַ���Ϊ���򷵻�false
		if (s.equals(""))
			return false;
//      ��ȡ�ַ�������
		int len = s.length();
		// ԭ���Ӹ��ո�(�ڱ�)��ʹ�±��1��ʼ������j��0��ʼ��Ҳ���ó�ʼ����
		s = " " + s;
//      ���ַ���ת��Ϊ�ַ�����
		char[] chars = s.toCharArray();
//      ����next����  
		int[] next = new int[len + 1];

		// ���� next ������̣�j��0��ʼ(�ո�)��i��2��ʼ
		for (int i = 2, j = 0; i <= len; i++) {
			// ƥ�䲻�ɹ���j�ص�ǰһλ�� next ��������Ӧ��ֵ
			while (j > 0 && chars[i] != chars[j + 1])
				j = next[j];
			// ƥ��ɹ���j������
			if (chars[i] == chars[j + 1])
				j++;
			// ���� next �����ֵ
			next[i] = j;
		}
//      ����һ����ƥ���ַ��Ƿ�Ϊ��С�ַ������ȵı���
		// ����ж��Ƿ����ظ������ַ��������� next[len] ������next����ĩβ��ֵ
		if (next[len] > 0 && len % (len - next[len]) == 0) {
			return true;
		}
		return false;
	}
}