//几何均值不等式+求导+最大值分析法 时间复杂度1 空间复杂度1
class Solution_extreme {
	public int cuttingRope(int n) {
		if (n <= 3) {
			return n - 1;
		}
		int a = n / 3, b = n % 3;
		if (b == 2) {
			return ((int) Math.pow(3, a)) * 2;
		}
		if (b == 1) {
			return ((int) Math.pow(3, a - 1)) * 4;
		}
		return (int) Math.pow(3, a);

	}
}

//动态规划法 时间复杂度n2 两段相乘 或 大于两段相乘
class Solution_dp {
	public int cuttingRope(int n) {
		/*
		 * dp五部曲: 1.状态定义:dp[i]为长度为i的绳子剪成m段最大乘积为dp[i] 2.状态转移:dp[i]有两种途径可以转移得到 2.1
		 * 由前一个dp[j]*(i-j)得到,即前面剪了>=2段,后面再剪一段,此时的乘积个数>=3个 2.2
		 * 前面单独成一段,后面剩下的单独成一段,乘积为j*(i-j),乘积个数为2
		 * 两种情况中取大的值作为dp[i]的值,同时应该遍历所有j,j∈[1,i-1],取最大值 3.初始化:初始化dp[1]=1即可 4.遍历顺序:显然为正序遍历
		 * 5.返回坐标:返回dp[n]
		 */
		// 定义dp数组
		int[] dp = new int[n + 1];
		// 初始化
		dp[1] = 1; // 指长度为1的单独乘积为1
		// 遍历[2,n]的每个状态
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i - 1; j++) {
				// 求出两种转移情况(乘积个数为2和2以上)的最大值
				int tmp = Math.max(dp[j] * (i - j), j * (i - j));
				dp[i] = Math.max(tmp, dp[i]);
			}
		}
		return dp[n];
	}
}

class Solution {
	public int cuttingRope(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j <= i - 1; j++) {
				int temp = Math.max(dp[j] * (i - j), j * (i - j));
				dp[i] = Math.max(temp, dp[i]);
			}
		}
		return dp[n];
	}
}