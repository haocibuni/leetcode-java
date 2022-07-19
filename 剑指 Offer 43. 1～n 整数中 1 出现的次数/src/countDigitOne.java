//每位累加法 时间复杂度logn 空间复杂度1
//若当前位为0 则出现1的次数为hight*digit
//若当前位为1 则出现1的次数为hight*digit+low+1
//若当前位为其它 则出现1的次数为(hight+1)*10
class Solution {
	public int countDigitOne(int n) {
		int digit = 1, res = 0;
		int hight = n / 10, cur = n % 10, low = 0;
//		若当前位和高位同时为0则说明越过最高位
		while (hight != 0 || cur != 0) {
			if (cur == 0) {
				res = res + hight * digit;
			} else if (cur == 1) {
				res = res + hight * digit + low + 1;
			} else {
				res = res + (hight + 1) * digit;
			}
//          按low-cur-hight的顺序进行改变
			low = low + cur * digit;
			cur = hight % 10;
			hight = hight / 10;
			digit = digit * 10;
		}
		return res;
	}
}