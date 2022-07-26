//分割法 时间复杂度n 空间复杂度n
//去除字符串的首位空格并以空格为分割进行划分
//对字符串数组进行倒序添加空格
//最后删除尾空格返回
class Solution_split {
	public String reverseWords(String s) {
//		split方法的时间复杂度为n trim当字符串全是空格时时间复杂度为n join时间复杂度为n reverse时间复杂度为n
//		python的split可以按多个空格 java的split只表示一个空格
		String[] strs = s.trim().split("\\s+");
		StringBuilder res = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			res.append(strs[i]);
			res.append(" ");
		}
		res.deleteCharAt(res.length() - 1);
		return res.toString();
	}
}

//双指针法 时间复杂度n 空间复杂度n
//定义指针i，j i指向单词的左边界 j指向单词的右边界
//按照i，j索引添加到res
//返回res
class Solution_doublepoint {
	public String reverseWords(String s) {
		s = s.trim();
		int i = s.length() - 1, j = i;
		StringBuilder res = new StringBuilder();

		while (i >= 0) {
			while (i >= 0 && s.charAt(i) != ' ') {
				i--;
			}
			res.append(s.substring(i + 1, j + 1));
			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
			}
			j = i;
		}
		return res.toString();

	}
}
