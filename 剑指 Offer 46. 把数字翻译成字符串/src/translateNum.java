//�ַ��������� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//�ַ�����������Ϊȥ����ǰ�ַ��ķ�����������ȥ����ǰ��λ�ַ��ķ���������ȥ����ǰ�ַ��ķ�������
class Solution_string {
	public int translateNum(int num) {
		String string = String.valueOf(num);
		int a = 1, b = 1;
		for (int i = 2; i <= string.length(); i++) {
//			��ȡ�ַ���
			String temp = string.substring(i - 2, i);
//			�ַ������ֱȽϴ�Сcompareto
			int c = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? a + b : a;
			b = a;
			a = c;
		}
		return a;

	}
}

//����ȡ�෨
//ͨ��ȡ�������λ�ʹε�λ
//����������б���
class Solution_mod {
	public int translateNum(int num) {
		int a = 1, b = 1, x, y = num % 10;
		while (num > 0) {
			num = num / 10;
			x = num % 10;
			int c = ((x * 10 + y) >= 10 && (x * 10 + y) <= 25) ? a + b : a;
			b = a;
			a = c;
			y = x;

		}
		return a;

	}
}