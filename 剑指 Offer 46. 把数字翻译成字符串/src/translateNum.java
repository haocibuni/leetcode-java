//字符串遍历法 时间复杂度n 空间复杂度n
//字符串翻译数量为去除当前字符的翻译数量或者去除当前两位字符的翻译数量加去除当前字符的翻译数量
class Solution_string {
	public int translateNum(int num) {
		String string = String.valueOf(num);
		int a = 1, b = 1;
		for (int i = 2; i <= string.length(); i++) {
//			截取字符串
			String temp = string.substring(i - 2, i);
//			字符串数字比较大小compareto
			int c = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? a + b : a;
			b = a;
			a = c;
		}
		return a;

	}
}

//数字取余法
//通过取余获得最低位和次低位
//从右往左进行遍历
class Solution_mod {
	public int translateNum(int num) {
		int a = 1, b = 1, x, y = num % 10;
		while (num > 0) {
			num = num / 10;
			x = num % 10;
			int c = ((x * 10 + y) >= 10 && (x * 10 + y) <= 25) ? a + b : a;
			b = a;
			a = c;
			y = x;

		}
		return a;

	}
}