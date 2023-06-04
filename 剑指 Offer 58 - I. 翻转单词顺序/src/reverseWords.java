//�ָ ʱ�临�Ӷ�n �ռ临�Ӷ�n
//ȥ���ַ�������λ�ո��Կո�Ϊ�ָ���л���
//���ַ���������е�����ӿո�
//���ɾ��β�ո񷵻�
class Solution_split {
	public String reverseWords(String s) {
//		split������ʱ�临�Ӷ�Ϊn trim���ַ���ȫ�ǿո�ʱʱ�临�Ӷ�Ϊn joinʱ�临�Ӷ�Ϊn reverseʱ�临�Ӷ�Ϊn
//		python��split���԰�����ո� java��splitֻ��ʾһ���ո�
		String[] strs = s.trim().split("\\s+");
		StringBuilder res = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			res.append(strs[i]);
			res.append(" ");
		}
		res.deleteCharAt(res.length() - 1);
		return res.toString();
	}
}

//˫ָ�뷨 ʱ�临�Ӷ�n �ռ临�Ӷ�n
//����ָ��i��j iָ�򵥴ʵ���߽� jָ�򵥴ʵ��ұ߽�
//����i��j������ӵ�res
//����res
class Solution_doublepoint {
	public String reverseWords(String s) {
		s = s.trim();
		int i = s.length() - 1, j = i;
		StringBuilder res = new StringBuilder();

		while (i >= 0) {
			while (i >= 0 && s.charAt(i) != ' ') {
				i--;
			}
			res.append(s.substring(i + 1, j + 1));
			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
			}
			j = i;
		}
		return res.toString();

	}
}
