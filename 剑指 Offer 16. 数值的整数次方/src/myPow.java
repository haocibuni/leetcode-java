
//�⺯����
class Solution_pow {
	public double myPow(double x, int n) {
		return Math.pow(x, n);
	}
}

//��������ݷ� ʱ�临�Ӷ� log2n
//�轫power�����ʹ�intת��long  -2^32תΪ����ʱ�����
class Solution_matirx {
	public double myPow(double x, int n) {
		long b = n;
		return pow(x, b);
	}

	double pow(double base, long n) {
		double temp = 1.0;
		if (base == 1.0) {
			return base;
		}
		if (n < 0) {
			n = n * -1;
			base = 1.0 / base;
		}
		while (n != 0) {
			if ((n & 1) == 1) {
				temp = temp * base;
			}
			base *= base;
			n >>= 1;
		}
		return temp;
	}
}