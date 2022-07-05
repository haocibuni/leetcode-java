//������Խ������µ��������⡱   (xy)��p=[(x��p)(y��p)]��p
//ѭ��ȡ�෨ ʱ�临�Ӷ�Ϊpower 
//tempΪ1 ��base���ȡ����Ϊ��temp ��Ҫpower��ȡ��
//��ע���ٵ��ú�������Ȼ��Ҫȡ��
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

//���������෨ ʱ�临�Ӷ�log2n
//����λΪ1����λΪ0ʱ ����Ҫ��temp��baseȡ��
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