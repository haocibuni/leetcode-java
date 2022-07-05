//“大数越界情况下的求余问题”   (xy)⊙p=[(x⊙p)(y⊙p)]⊙p
//循环取余法 时间复杂度为power 
//temp为1 与base相乘取余作为新temp 需要power次取余
//需注意再调用函数后仍然需要取余
class Solution_whilemod {
	public int cuttingRope(int n) {
		int mod = 1000000007;
		if (n <= 3) {
			return n - 1;
		}
		int b = n % 3;
		long a = n / 3, x = 3;
		if (b == 2) {
			return (int) (modwhile(x, a, mod) * 2 % mod);
		}
		if (b == 1) {
			return (int) (modwhile(x, a - 1, mod) * 4 % mod);
		}
		return (int) (modwhile(x, a, mod) % mod);

	}

	public long modwhile(long base, long power, int mod) {
		long temp = 1;
		for (int i = 0; i < power; i++) {
			temp = (temp * base) % mod;
		}
		return temp;

	}
}

//快速幂求余法 时间复杂度log2n
//当数位为1和数位为0时 都需要对temp和base取余
class Solution_matrix {
	public int cuttingRope(int n) {
		int mod = 1000000007;
		if (n <= 3) {
			return n - 1;
		}
		int b = n % 3;
		long a = n / 3, x = 3;
		if (b == 2) {
			return (int) (modwhile(x, a, mod) * 2 % mod);
		}
		if (b == 1) {
			return (int) (modwhile(x, a - 1, mod) * 4 % mod);
		}
		return (int) (modwhile(x, a, mod) % mod);

	}

	public long modwhile(long base, long power, int mod) {
		long temp = 1;
		while (power > 0) {
			if (power % 2 == 1) {
				temp = (temp * base) % mod;
			}
			base = (base * base) % mod;
			power = power / 2;
		}
		return temp % mod;

	}
}