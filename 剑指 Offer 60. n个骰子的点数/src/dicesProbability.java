import java.util.Arrays;

//动态规划逆向法   时间复杂度n2 空间复杂度n2
//骰子个数为n 点数和为n-6*n 为5*n+1 f(n,x)表示骰子个数为n时点数和为x的概率
//动态规划方程为f(n,x) = 累加f(n-1,x-i) i为1-6
//其中x-i可能为负数所以要break 如f(2,2)
class Solution_dp {
	public double[] dicesProbability(int n) {
//		结果数组 长度为点数和数量
		double[] res = new double[5 * n + 1];
//		动态规划数组 大小为骰子个数*最大点数和
		double[][] dp = new double[n + 1][6 * n + 1];
//		初始化一个骰子时各点数和的概率
		for (int i = 1; i <= 6; i++) {
//			double要用小数
			dp[1][i] = 1.0 / 6;
		}
//		i为骰子数量
		for (int i = 2; i <= n; i++) {
//			j为点数和区间
			for (int j = i; j <= n * 6; j++) {
//				k为减去的前面的点数
				for (int k = 1; k <= 6; k++) {
					if (j - k >= 0) {
						dp[i][j] = (dp[i - 1][j - k]) / 6 + dp[i][j];
					} else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < 5 * n + 1; i++) {
			res[i] = dp[n][n + i];
		}
		return res;

	}
}

//动态规划正向法   时间复杂度n2 空间复杂度n
//具体来看，由于新增骰子的点数只可能为 1 至 6 ，
//因此概率 f(n - 1, x)f(n−1,x) 仅与 f(n, x + 1)f(n,x+1) , f(n, x + 2)f(n,x+2), ... , f(n, x + 6)f(n,x+6) 相关。
//因而，遍历 f(n - 1)f(n−1) 中各点数和的概率，并将其相加至 f(n)f(n) 中所有相关项，即可完成 f(n - 1)f(n−1) 至 f(n)f(n) 的递推。
class Solution {
	public double[] dicesProbability(int n) {
		double[] dp = new double[6];
		Arrays.fill(dp, 1.0 / 6.0);
		for (int i = 2; i <= n; i++) {
			double[] tmp = new double[5 * i + 1];
			for (int j = 0; j < dp.length; j++) {
				for (int k = 0; k < 6; k++) {
					tmp[j + k] += dp[j] / 6.0;
				}
			}
			dp = tmp;
		}
		return dp;
	}
}
