//除法法 时间复杂度n 空间复杂度1
class Solution_divide {
	public int[] constructArr(int[] a) {
		int mul = 1;
		int flag = 0;
		for (int num : a) {
			if (num == 0) {
				flag++;
				continue;
			}
			mul = mul * num;
		}
		for (int i = 0; i < a.length; i++) {
			if (flag != 0 && a[i] != 0) {
				a[i] = 0;
			} else if (flag == 0) {
				a[i] = mul / a[i];
			} else if (flag > 0 && a[i] == 0) {
				if (flag > 1) {
					a[i] = 0;
				} else {
					a[i] = mul;
				}

			}
		}
		return a;
	}
}

//构建乘积数组法 时间复杂度n 空间复杂度1
class Solution {
	public int[] constructArr(int[] a) {
		if (a.length == 0) {
			return new int[0];
		}
		int[] dp = new int[a.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i - 1] * a[i - 1];
		}
		int temp = 1;
		for (int j = a.length - 2; j >= 0; j--) {
			temp = temp * a[j + 1];
			dp[j] = dp[j] * temp;
		}
		return dp;

	}
}