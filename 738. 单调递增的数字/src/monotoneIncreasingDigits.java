//贪心算法 从后往前
class Solution {
	public int monotoneIncreasingDigits(int n) {
//		将整型转化为字符串
		String s = String.valueOf(n);
//		将字符串转化为字符数组
		char[] chars = s.toCharArray();
//		初始化填充9的下标
		int start = s.length();
//		从倒数第二位开始遍历
		for (int i = s.length() - 2; i >= 0; i--) {
//			如果当前字符大于下一个字符，则减1，并将设9的下标标记为下一位
			if (chars[i] > chars[i + 1]) {
				chars[i]--;
				start = i + 1;
			}
		}
//		填充9
		for (int i = start; i < chars.length; i++) {
			chars[i] = '9';
		}
//		将字符数组转化为字符串，再将字符串转为整型
		return Integer.parseInt(String.valueOf(chars));

	}
}