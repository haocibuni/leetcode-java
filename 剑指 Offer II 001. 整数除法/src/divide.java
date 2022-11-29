class Solution {
	public int divide(int a, int b) {
		while (((b >> 1) & 1) == 0) {

			a = a >> 1;
		}
		return a;
	}
}

class Solutio1 {
	public int divide(int a, int b) {
		if (a == Integer.MIN_VALUE && b == -1) {
			return Integer.MAX_VALUE;
		}
		int sign = (a > 0) ^ (b > 0) ? -1 : 1;
//		a = Math.abs(a);
//		b = Math.abs(b);
		if (a > 0) {
			a = -a;
		}
		if (b > 0) {
			b = -b;
		}
		int count = 0;

		while (a <= b) {
			int value = b;
			int k = 1;
			while (value >= 0xc0000000 && a <= value + value) {
				k += k;
				value += value;
			}
			a -= value;
			count += k;

		}
		return sign * count;
	}
}

//λ���㷨
class divide {
	public int divide(int a, int b) {
		if (a == Integer.MIN_VALUE && b == -1) {
			return Integer.MAX_VALUE;
		}
		int sign = (a > 0) ^ (b > 0) ? -1 : 1;
		int res = 0;
//		��aΪInteger.MIN_VALUE ȡ����ֵ��a��ΪInteger.MIN_VALUE
		a = Math.abs(a);
		b = Math.abs(b);
//		a-(b<<i)=a>0 ����a�϶�С��a��1/2,��b<<i�϶�����a��1/2,���Բ������¿�ʼѭ��ֱ�Ӵ���һ��i��ʼ����
		for (int i = 31; i >= 0; i--) {
//			a>=b<<i b���ο��ܻ�Խ��
//			��aΪInteger.MIN_VALUE ȡ����ֵ��a��ΪInteger.MIN_VALUE �����޷������ƻ��Ϊ����
//			��bΪInteger.MIN_VALUE ȡ����ֵ��b��ΪInteger.MIN_VALUE ��ΪbΪ��Сֵ�����ж�������ԶΪtrue �κ�ֵ������Сֵ�϶�С��0 �᷵��false
			if ((a >>> i) - b >= 0) {
				a -= (b << i);
				res += (1 << i);
			}
		}
		return sign == 1 ? res : -res;

	}

	public static void main(String[] args) {
		divide solutio2 = new divide();
		System.out.println(Math.abs(Integer.MIN_VALUE));
		System.out.println(solutio2.divide(Integer.MIN_VALUE, 1));
	}
}