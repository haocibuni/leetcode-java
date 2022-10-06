//动态规划压缩法
class Solution {
	public int fib(int n) {
//		若n小于等于1，直接返回本身
		if (n <= 1) {
			return n;
		}
//		a表示fn-2 b表示fn-1 c表示fn
		int a = 0, b = 1, c = 0;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;

	}
}