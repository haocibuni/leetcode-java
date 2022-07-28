//动态规划法 时间复杂度n 空间复杂度1
//设f(n)为输入n个数最后留下的一个数字
//删除的数字为(m-1)%n 删除后的数字从m%n开始
//删除一轮数字后f(n)变成了f(n-1)问题
//f(n)
//=(f(n−1)+t)%n
//=(f(n−1)+m%n)%n
//=(f(n−1)+m)%n
​

class Solution {
	public int lastRemaining(int n, int m) {
		int x = 0;
		for (int i = 2; i <= n; i++) {
			x = (x + m) % i;
		}
		return x;

	}
}