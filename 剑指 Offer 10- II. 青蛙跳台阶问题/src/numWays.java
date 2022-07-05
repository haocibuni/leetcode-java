//动态规划法 时间复杂度On
class Solution_dp {
	public int numWays(int n) {
		if (n < 2) {
			return 1;
		}
		int mod = 1000000007;
		int a = 1, b = 1, c = 2;
		for (int i = 2; i <= n; i++) {
			a = b;
			b = c;
			c = (a + b) % mod;
		}
		return c;

	}
}

//矩阵快速幂法 时间复杂度logn
class Solution_matrix {
	public int numWays(int n) {
		if (n < 2) {
			return 1;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int[][] ans;
		int power = n;
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