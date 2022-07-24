//有限自动机法 时间复杂度n 空间复杂度1
class Solution_binary {
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for (int num : nums) {
			ones = ones ^ num & ~twos;
			twos = twos ^ num & ~ones;
		}
		return ones;

	}
}

//循环遍历法 时间复杂度n 空间复杂度1
//使用与运算1获取数字最后一位是否为1，然后加在对应位上，数字右移一位继续循环
//count表示所有数二进制从位到头为1的数量
//然后使用左移一位和或运算获取res 或运算1除了1之外其它数的结果都为0
class Solution_for {
	public int singleNumber(int[] nums) {
		int[] count = new int[32];
		for (int num : nums) {
			for (int j = 0; j < 32; j++) {
				count[j] += num & 1;
				num >>>= 1;
			}
		}
		int res = 0, m = 3;
		for (int i = 0; i < 32; i++) {
			res <<= 1;
			res |= count[31 - i] % m;
		}
		return res;

	}
}