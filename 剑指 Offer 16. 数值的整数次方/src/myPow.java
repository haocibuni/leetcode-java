
//库函数法
class Solution_pow {
	public double myPow(double x, int n) {
		return Math.pow(x, n);
	}
}

//矩阵快速幂法 时间复杂度 log2n
//需将power的类型从int转成long  -2^32转为正数时会溢出
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