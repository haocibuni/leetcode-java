
class Solution {
	public String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();
		boolean flag = false;
		for (int i = b.length() - 1; i >= 0; i--) {
//			当前位为0
			if ((a.charAt(i) == '1' && b.charAt(i) == '1') || (a.charAt(i) == '0' && b.charAt(i) == '0')) {
//				若进位则为1 不进位则为0
				if (flag) {
					res.append('1');
				} else {
					res.append('0');
				}
				if (a.charAt(i) == '1' && b.charAt(i) == '1') {
					flag = true;
				} else {
					flag = false;
				}
//			当前位为1
			} else {
//				若进位则为0 下一进位 不进位则为1 下一位不进位
				if (flag) {
					res.append('0');
					flag = true;

				} else {
					res.append('1');
					flag = false;

				}

			}

		}
		if (flag) {
			res.append('1');
		}
		return res.reverse().toString();

	}
}

class Solution2 {
	public String addBinary(String a, String b) {
		return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));

	}
}

//位运算法
class Solution3 {
	public String addBinary(String a, String b) {

		int inta = Integer.parseInt(a, 2), intb = Integer.parseInt(b, 2);
		int temp;
		while (intb != 0) {
			temp = inta;
			inta = inta ^ intb;
			intb = (temp & intb) << 1;
		}
		return Integer.toBinaryString(inta);

	}
}

//模拟法
class Solution4 {
	public String addBinary(String a, String b) {
		int alen = a.length(), blen = b.length();
		int len = Math.max(alen, blen);
		int carry = 0;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < len; i++) {
			carry += i >= alen ? 0 : (a.charAt(alen - 1 - i) - '0');
			carry += i >= blen ? 0 : (b.charAt(blen - 1 - i) - '0');
			res.append((char) (carry % 2 + '0'));
			carry = carry / 2;
		}
		if (carry > 0) {
			res.append('1');
		}
		return res.reverse().toString();
	}
}