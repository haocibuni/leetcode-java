//起始数字+数位法 时间复杂度logn 空间复杂度logn
//给定数位，首先通过while循环确定数位所在的位数和起始数字
//然后确定所在数位的数字
//最后确定数位在数字的哪一位
//  数学
//           数字范围   位数   数字数量   数位数量
//            1 - 9      1        9          9
//           10 - 99     2        90         180
//          100 - 999    3        900        2700
//             ...      ...       ...        ...
//        start - end   digit    9*start   9*start*dight

class Solution {
	public int findNthDigit(int n) {
		int digit = 1;
//		将数位总和和数位的起始数字用long
		long start = 1;
		long count = 9;
		while (n > count) {
//			long和int相减
			n -= count;
			start = start * 10;
			digit = digit + 1;
			count = 9 * start * digit;
		}
		long num = start + (n - 1) / digit;
//		将long转化位string
		String string = Long.toString(num);
//		将string转化位int
		return string.charAt((n - 1) % digit) - '0';
	}
}