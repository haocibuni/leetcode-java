//位运算法 时间复杂度n 空间复杂度1
//进位为与运算 非进位为异或运算
//终止条件为进位为0 时 返回非进位
class Solution {
	public int add(int a, int b) {
		while (b != 0) {
			int c = (a & b) << 1;
			a = a ^ b;
			b = c;
		}
		return a;

	}
}