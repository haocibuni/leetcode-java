import java.util.ArrayList;
import java.util.List;

//回溯剪枝法
class Solution {
//	点个数
	int pointNum = 0;
//	字符串一维数组
	List<String> result = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {
		backTracking(s, 0);
		return result;
	}

	public void backTracking(String s, int startIndex) {
//		若点个数等于3
		if (pointNum == 3) {
//			且剩余字符串符合ip地址格式，则将字符串s添加到结果数组
			if (isValid(s, startIndex, s.length() - 1)) {
				result.add(s);
			}
			return;
		}
//		遍历字符串
		for (int i = startIndex; i < s.length(); i++) {
//			判断从startIndex到i是否符合ip格式
			if (isValid(s, startIndex, i)) {
//				若符合则点数量加加
				pointNum++;
//				在字符串中添加点
				s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
//				递归判断点之后的是否符合
				backTracking(s, i + 2);
//				回溯点--
				pointNum--;
//				去除字符串中的点
				s = s.substring(0, i + 1) + s.substring(i + 2);
			} else {
//				若不符合则从该处开始的子字符串全都不符合
				break;
			}

		}
	}

	public boolean isValid(String s, int begin, int end) {
		if (begin > end) {
			return false;
		}
//		大于1且0开始的字符串
		if (s.charAt(begin) == '0' && begin != end) { // 0开头的数字不合法
			return false;
		}
//		字符串转为数字判断
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