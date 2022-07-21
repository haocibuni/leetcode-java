//动态规划法 时间复杂度n 空间复杂度n
//丑数=某个较小丑数*某个因子
//设置a,b,c指针指向第一个丑数1
//然后根据递推公式获取下一个丑数
//假设已有的丑数序列为[1, 2, 3, ..., n1, n2], 如果单纯的让每个丑数乘2， 乘3， 乘5顺序排列的话肯定会有问题，
//比如如果按照这样的顺序排列下去肯定有问题[1*2, 1*3, 1*5, 2*2, 2*3, 2*5, 3*2, 3*3, 3*5, ... , n1 *2, n1 * 3, n1 * 5, n2 * 2, n3* 3, n2 * 5]，
//因为后面乘2的数据可能会比前面乘3乘5的数据要小，那这个乘2的数应该排在他们的前面， 后面乘3的数据也可能比前面乘5的数据要小，那这个乘3的数应该排在他们的前面。
//A马一次只能跳两格，B马一次只能跳3格，C马一次只能跳5格。哪匹马落后最多，哪匹马就多跳一次，然后再比较三匹马哪个落后最多，再多跳一次......直到三匹马跳的总次数为n为止。
class Solution {
	public int nthUglyNumber(int n) {
		int a = 0, b = 0, c = 0;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
			dp[i] = Math.min(n2, Math.min(n3, n5));
			if (dp[i] == n2) {
				a++;
			}
			if (dp[i] == n3) {
				b++;
			}
			if (dp[i] == n5) {
				c++;
			}
		}
		return dp[n - 1];

	}
}