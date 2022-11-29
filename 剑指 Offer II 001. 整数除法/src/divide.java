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

//位运算法
class divide {
	public int divide(int a, int b) {
		if (a == Integer.MIN_VALUE && b == -1) {
			return Integer.MAX_VALUE;
		}
		int sign = (a > 0) ^ (b > 0) ? -1 : 1;
		int res = 0;
//		若a为Integer.MIN_VALUE 取绝对值后a还为Integer.MIN_VALUE
		a = Math.abs(a);
		b = Math.abs(b);
//		a-(b<<i)=a>0 其中a肯定小于a的1/2,而b<<i肯定大于a的1/2,所以不必重新开始循环直接从下一个i开始即可
		for (int i = 31; i >= 0; i--) {
//			a>=b<<i b座椅可能会越界
//			若a为Integer.MIN_VALUE 取绝对值后a还为Integer.MIN_VALUE 采用无符号右移会变为正数
//			若b为Integer.MIN_VALUE 取绝对值后b还为Integer.MIN_VALUE 因为b为最小值所以判断条件永远为true 任何值减掉最小值肯定小于0 会返回false
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