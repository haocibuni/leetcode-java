//ÿλ�ۼӷ� ʱ�临�Ӷ�logn �ռ临�Ӷ�1
//����ǰλΪ0 �����1�Ĵ���Ϊhight*digit
//����ǰλΪ1 �����1�Ĵ���Ϊhight*digit+low+1
//����ǰλΪ���� �����1�Ĵ���Ϊ(hight+1)*10
class Solution {
	public int countDigitOne(int n) {
		int digit = 1, res = 0;
		int hight = n / 10, cur = n % 10, low = 0;
//		����ǰλ�͸�λͬʱΪ0��˵��Խ�����λ
		while (hight != 0 || cur != 0) {
			if (cur == 0) {
				res = res + hight * digit;
			} else if (cur == 1) {
				res = res + hight * digit + low + 1;
			} else {
				res = res + (hight + 1) * digit;
			}
//          ��low-cur-hight��˳����иı�
			low = low + cur * digit;
			cur = hight % 10;
			hight = hight / 10;
			digit = digit * 10;
		}
		return res;
	}
}