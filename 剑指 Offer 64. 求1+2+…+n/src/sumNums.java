//��·ЧӦ�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//if(A && B)  // �� A Ϊ false ���� B ���жϲ���ִ�У�����·����ֱ���ж� A && B Ϊ false
//if(A || B) // �� A Ϊ true ���� B ���жϲ���ִ�У�����·����ֱ���ж� A || B Ϊ true
//����ǰ�߶��������������Ĳ��ᱻִ�� ǰ��������˺����Ҳ����ִ��
class Solution {
	public int sumNums(int n) {
		boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
		return n;
	}
}