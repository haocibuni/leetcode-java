//数字越界处理法
//删除首尾空格
//判断符号位即+-或无符号
//若碰到非数字的字符则直接break
//字符减去0字符的ASCII码即位当前字符的数字 然后将res*10并添加当前数字
//如果在未进位之前>Integer.MAX_VALUE/10则进位后肯定超越边界
//如果在未进位之前=Integer.MAX_VALUE/10则进位后若当前数字大于7肯定超越边界
class Solution {
	public int strToInt(String str) {
		char[] chars = str.trim().toCharArray();
		if (chars.length == 0) {
			return 0;
		}
		int res = 0, bndry = Integer.MAX_VALUE / 10;
		int i = 1, sign = 1;
		if (chars[0] == '-') {
			sign = -1;
		} else if (chars[0] != '+') {
			i = 0;
		}
		for (int j = i; j < chars.length; j++) {
			if (chars[j] < '0' || chars[j] > '9') {
				break;
			}
			if (res > bndry || res == bndry && chars[j] > '7') {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + (chars[j] - '0');

		}
		return sign * res;

	}
}