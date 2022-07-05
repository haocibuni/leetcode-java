//pow计算end法 时间复杂度10n
class Solution_end {
	public int[] printNumbers(int n) {
		int end = (int) Math.pow(10, n) - 1;
		int[] numbers = new int[end];
		for (int i = 0; i < end; i++) {
			numbers[i] = i + 1;
		}
		return numbers;

	}
}

//大数法 字符串模拟加法
//stringbuilder是一个可变的字符串类
//substring() 方法返回字符串的子字符串  参数为 beginIndex -- 起始索引（包括）, 索引从 0 开始。 endIndex -- 结束索引（不包括）。
class Solution_bigdata {
//	字符串模拟int数组
	StringBuilder resBuilder;
//	单个数字num 和 字符串数组
	char[] num, loop = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
//	位数n，num非零起始下标，num的当前位数-1
	int n, start, nine = 0;

	public String printNumbers(int n) {
		this.n = n;
		this.start = n - 1;
		resBuilder = new StringBuilder();
		num = new char[n];
		DFS(0);
//		删除最后的逗号
		resBuilder.deleteCharAt(resBuilder.length() - 1);
		return resBuilder.toString();
	}

//深度搜索，深度为位数n
	public void DFS(int x) {
		if (x == n) {
//			取出num字符数组的非零部分
			String s = String.valueOf(num).substring(start);
			if (!s.equals("0")) {
//				若当前位数 == 总位数n-0的位数
				if (n - start == nine) {
					start--;
				}
				resBuilder.append(s + ',');
			}
			return;
		}
		for (char i : loop) {
//			若当前位为9 则进位
			if (i == '9') {
				nine++;
			}
			num[x] = i;
//			深度搜索下一位
			DFS(x + 1);
		}
		nine--;
	}
}