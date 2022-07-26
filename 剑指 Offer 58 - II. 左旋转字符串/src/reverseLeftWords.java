//������ӷ� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//�൱����Ƭ�� s.substring(n, s.length()) + s.substring(0, n);
//�������� Ȼ������ʱ�
class Solution_StringBuilder {
	public String reverseLeftWords(String s, int n) {
		if (s.length() == n) {
			return s;
		}
		StringBuilder res = new StringBuilder();
		for (int i = n; i < s.length(); i++) {
			res.append(s.charAt(i));
		}
		for (int i = 0; i < n; i++) {
			res.append(s.charAt(i));
		}
		return res.toString();
	}
}

//ȡ�෨ 
//�򻯴��� ������ѭ��ת��Ϊһ��ѭ��
class Solution_mod {
	public String reverseLeftWords(String s, int n) {
		StringBuilder res = new StringBuilder();
//		����߿�ʼ����n+s.length ����n����s.lenghȡ��
		for (int i = n; i < n + s.length(); i++)
			res.append(s.charAt(i % s.length()));
		return res.toString();
	}
}