import java.util.ArrayList;
import java.util.List;

class Solution {
	int pointNum = 0;
	List<String> result = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {
		backTracking(s, 0);
		return result;
	}

	public void backTracking(String s, int startIndex) {
		if (pointNum == 3) {
			if (isValid(s, startIndex, s.length() - 1)) {
				result.add(s);
			}
			return;
		}
		for (int i = startIndex; i < s.length(); i++) {
			if (isValid(s, startIndex, i)) {
				pointNum++;
				s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
				backTracking(s, i + 2);
				pointNum--;
				s = s.substring(0, i + 1) + s.substring(i + 2);
			} else {
				break;
			}

		}
	}

	public boolean isValid(String s, int begin, int end) {
		if (begin > end) {
			return false;
		}
		if (s.charAt(begin) == '0' && begin != end) { // 0开头的数字不合法
			return false;
		}
		int num = 0;
		for (int i = begin; i <= end; i++) {
			if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
				return false;
			}
			num = num * 10 + (s.charAt(i) - '0');
			if (num > 255) { // 如果⼤于255了不合法
				return false;
			}
		}
		return true;
	}
}