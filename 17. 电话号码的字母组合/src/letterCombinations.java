import java.util.ArrayList;
import java.util.List;

//回溯法
class Solution {
//	定义结果字符数组和临时数组builder
	List<String> result = new ArrayList<>();
	StringBuilder temp = new StringBuilder();

	public List<String> letterCombinations(String digits) {
//		map字符数组：下标与数字对应
		String[] numString = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		if (digits == null || digits.length() == 0) {
			return result;
		}
		backTracking(digits, numString, 0);
		return result;

	}

	public void backTracking(String digits, String[] numString, int num) {
		if (num == digits.length()) {
			result.add(temp.toString());
			return;
		}
//		遍历对应数字对应的字母字符集合
		for (char c : numString[digits.charAt(num) - '0'].toCharArray()) {
//			builder添加字符
			temp.append(c);
//			递归下一个数字
			backTracking(digits, numString, num + 1);
//			builder删除字符
			temp.deleteCharAt(temp.length() - 1);
		}

	}
}