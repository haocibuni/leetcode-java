//递归法  时间复杂度为2的n次方
class Solution_recur {
	public int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;

		}
		return fib(n - 1) + fib(n - 2) % 1000000007;
	}
}

//递归记忆法 时间复杂度n
class Solution_recur_memory {
	static int mod = 1000000007;
	static int N = 110;
	static int[] cache = new int[N];

	public int fib(int n) {
		if (n < 2) {
			return n;
		}
		if (cache[n] != 0) {
			return cache[n];
		}
		cache[n] = fib(n - 1) + fib(n - 2);
		cache[n] = cache[n] % mod;
		return cache[n];

	}
}

//预设if法 时间复杂度为1
class Solution_if {
	public int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		if (n == 3)
			return 2;
		if (n == 4)
			return 3;
		if (n == 5)
			return 5;
		if (n == 6)
			return 8;
		if (n == 7)
			return 13;
		if (n == 8)
			return 21;
		if (n == 9)
			return 34;
		if (n == 10)
			return 55;
		if (n == 11)
			return 89;
		if (n == 12)
			return 144;
		if (n == 13)
			return 233;
		if (n == 14)
			return 377;
		if (n == 15)
			return 610;
		if (n == 16)
			return 987;
		if (n == 17)
			return 1597;
		if (n == 18)
			return 2584;
		if (n == 19)
			return 4181;
		if (n == 20)
			return 6765;
		if (n == 21)
			return 10946;
		if (n == 22)
			return 17711;
		if (n == 23)
			return 28657;
		if (n == 24)
			return 46368;
		if (n == 25)
			return 75025;
		if (n == 26)
			return 121393;
		if (n == 27)
			return 196418;
		if (n == 28)
			return 317811;
		if (n == 29)
			return 514229;
		if (n == 30)
			return 832040;
		if (n == 31)
			return 1346269;
		if (n == 32)
			return 2178309;
		if (n == 33)
			return 3524578;
		if (n == 34)
			return 5702887;
		if (n == 35)
			return 9227465;
		if (n == 36)
			return 14930352;
		if (n == 37)
			return 24157817;
		if (n == 38)
			return 39088169;
		if (n == 39)
			return 63245986;
		if (n == 40)
			return 102334155;
		if (n == 41)
			return 165580141;
		if (n == 42)
			return 267914296;
		if (n == 43)
			return 433494437;
		if (n == 44)
			return 701408733;
		if (n == 45)
			return 134903163;
		if (n == 46)
			return 836311896;
		if (n == 47)
			return 971215059;
		if (n == 48)
			return 807526948;
		if (n == 49)
			return 778742000;
		if (n == 50)
			return 586268941;
		if (n == 51)
			return 365010934;
		if (n == 52)
			return 951279875;
		if (n == 53)
			return 316290802;
		if (n == 54)
			return 267570670;
		if (n == 55)
			return 583861472;
		if (n == 56)
			return 851432142;
		if (n == 57)
			return 435293607;
		if (n == 58)
			return 286725742;
		if (n == 59)
			return 722019349;
		if (n == 60)
			return 8745084;
		if (n == 61)
			return 730764433;
		if (n == 62)
			return 739509517;
		if (n == 63)
			return 470273943;
		if (n == 64)
			return 209783453;
		if (n == 65)
			return 680057396;
		if (n == 66)
			return 889840849;
		if (n == 67)
			return 569898238;
		if (n == 68)
			return 459739080;
		if (n == 69)
			return 29637311;
		if (n == 70)
			return 489376391;
		if (n == 71)
			return 519013702;
		if (n == 72)
			return 8390086;
		if (n == 73)
			return 527403788;
		if (n == 74)
			return 535793874;
		if (n == 75)
			return 63197655;
		if (n == 76)
			return 598991529;
		if (n == 77)
			return 662189184;
		if (n == 78)
			return 261180706;
		if (n == 79)
			return 923369890;
		if (n == 80)
			return 184550589;
		if (n == 81)
			return 107920472;
		if (n == 82)
			return 292471061;
		if (n == 83)
			return 400391533;
		if (n == 84)
			return 692862594;
		if (n == 85)
			return 93254120;
		if (n == 86)
			return 786116714;
		if (n == 87)
			return 879370834;
		if (n == 88)
			return 665487541;
		if (n == 89)
			return 544858368;
		if (n == 90)
			return 210345902;
		if (n == 91)
			return 755204270;
		if (n == 92)
			return 965550172;
		if (n == 93)
			return 720754435;
		if (n == 94)
			return 686304600;
		if (n == 95)
			return 407059028;
		if (n == 96)
			return 93363621;
		if (n == 97)
			return 500422649;
		if (n == 98)
			return 593786270;
		if (n == 99)
			return 94208912;
		if (n == 100)
			return 687995182;
		return (fib(n - 1) + fib(n - 2)) % 1000000007;
	}
}

//递推实现动态规划法 时间复杂度为n 空间复杂度为1
class Solution_dp {
	public int fib(int n) {
		int mod = 1000000007;
		if (n == 0 || n == 1) {
			return n;
		}
		int p = 0, q = 0, r = 1;
		for (int i = 2; i <= n; i++) {
			p = q;
			q = r;
			r = (p + q) % mod;
		}
		return r;
	}
}

//矩阵快速幂 时间复杂度logn，
//我们在计算一个数的多次幂时，可以先判断其幂次的奇偶性，然后：
//如果幂次为偶直接 base(底数) 作平方，power(幂次) 除以2
//如果幂次为奇则底数平方，幂次整除于2然后再多乘一次底数
class Solution_matrix {
	public int fib(int n) {
		if (n < 2) {
			return n;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int[][] ans;
		int power = n - 1;
		ans = cal(base, power);
		return ans[0][0];

	}

	public int[][] cal(int[][] base, int power) {
		int[][] res = { { 1, 0 }, { 0, 1 } };
		while (power > 0) {
			if (power % 2 == 1) {
				res = mul(base, res);
			}
			power = power / 2;
			base = mul(base, base);
		}
		return res;

	}

	public int[][] mul(int[][] a, int[][] b) {
		int[][] matrix = new int[2][2];
		int mod = 1000000007;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				matrix[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % mod);
			}
		}
		return matrix;

	}
}
//n=19，写成二进制为10011，那么我们把m^19拆分为m^2^4m^2^1m^2^0