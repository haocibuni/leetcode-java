//遍历添加法 时间复杂度n 空间复杂度n
//相当于切片法 s.substring(n, s.length()) + s.substring(0, n);
//先添加左边 然后添加邮编
class Solution_StringBuilder {
	public String reverseLeftWords(String s, int n) {
		if (s.length() == n) {
			return s;
		}
		StringBuilder res = new StringBuilder();
		for (int i = n; i < s.length(); i++) {
			res.append(s.charAt(i));
		}
		for (int i = 0; i < n; i++) {
			res.append(s.charAt(i));
		}
		return res.toString();
	}
}

//取余法 
//简化代码 将两次循环转换为一次循环
class Solution_mod {
	public String reverseLeftWords(String s, int n) {
		StringBuilder res = new StringBuilder();
//		从左边开始，到n+s.length 大于n后会对s.lengh取余
		for (int i = n; i < n + s.length(); i++)
			res.append(s.charAt(i % s.length()));
		return res.toString();
	}
}