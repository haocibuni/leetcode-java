//��ת���η� ʱ�临�Ӷ�n �ռ临�Ӷ�1
class Solution {
	/**
	 * ˼·�� �ٷ�ת�ַ��� "the sky is blue " => " eulb si yks eht" �ڱ��� " eulb si yks
	 * eht"��ÿ���ȶ�ĳ�����ʽ��з�ת����λ �����Ե�һ�����ʽ���Ϊ��ʾ��" eulb si yks eht" ==��ת=> " blue si yks
	 * eht" ==��λ=> "blue si yks eht"
	 */
	public String reverseWords(String s) {
		// ����1���ַ������巴ת����ʱ���еĵ���Ҳ����ת�ˣ�
		char[] initialArr = s.toCharArray();
		reverse(initialArr, 0, s.length() - 1);
		int k = 0;
		for (int i = 0; i < initialArr.length; i++) {
//			��������ǰ�Ŀո�tempcurΪ���ʿ�ʼ������
			if (initialArr[i] == ' ') {
				continue;
			}
//			������Ӧ�ĵ��ʣ�iΪ��ȡ������������
			int tempCur = i;
			while (i < initialArr.length && initialArr[i] != ' ') {
				i++;
			}
//			�����ӵ��ʵĿ�ʼ������
			for (int j = tempCur; j < i; j++) {
//				���ȶ�ָ����Χ�ڵĵ��ʽ��з�ת
				if (j == tempCur) { // ����������η�ת
					reverse(initialArr, tempCur, i - 1);// ��ָ����Χ�ַ������з�ת������ת�Ӻ���ǰ����һ�������������
				}
				// ����ת�����ĸ��ӵ���Ӧ��λ��
				initialArr[k++] = initialArr[j];
				if (j == i - 1) { // ��������
					// ����Խ�����������=> "asdasd df f"�������ж����ͻ�����Խ��
					if (k < initialArr.length) {
						initialArr[k++] = ' ';
					}
				}
			}
		}
		if (k == 0) {
			return "";
		} else {
			// ���������Է�������"asdasd df f"=>"f df asdasd"���ô�������Ҫʡ�Կո����
			return new String(initialArr, 0, (k == initialArr.length) && (initialArr[k - 1] != ' ') ? k : k - 1);
		}
	}

	public void reverse(char[] chars, int begin, int end) {
		for (int i = begin, j = end; i < j; i++, j--) {
			chars[i] ^= chars[j];
			chars[j] ^= chars[i];
			chars[i] ^= chars[j];
		}
	}
}