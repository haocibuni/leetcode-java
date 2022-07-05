//int对2取余 并除2 时间复杂度log2n 错误
//超限
class Solution_mod2 {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int sum = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				sum = sum + 1;
			}
			n = n / 2;
		}
		return sum;
	}

}

//位运算法 时间复杂度log2n
//终止条件n！=0 最右位判断(n & 1)  
//Java 中无符号右移为 ">>>"
//">>>"无符号右移
//操作规则：无论正负数，前面补零。
//">>"右移
//操作规则：正数前面补零，负数前面补1
//"<<"左移
//操作规则：无论正负数，后面补零。
class Solution_bit {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int sum = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				sum = sum + 1;
			}
			n >>>= 1;
		}
		return sum;
	}

}

// 巧用n&(n-1)法 时间复杂度O(M) 二进制数中1的个数
// (n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
// n&(n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，其余不变。
class Solution_hideleft1 {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			n = n & (n - 1);
		}
		return sum;
	}

}