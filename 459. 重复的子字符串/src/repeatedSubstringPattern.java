//移动匹配法 时间复杂度mn 空间复杂度2n
//掐头去尾
class Solution {
	public boolean repeatedSubstringPattern(String s) {
		String newString = s + s;
		return newString.substring(1, newString.length() - 1).contains(s);

	}
}

//KMP法
class Solution_next {
	public boolean repeatedSubstringPattern(String s) {
//    	若字符串为空则返回false
		if (s.equals(""))
			return false;
//      获取字符串长度
		int len = s.length();
		// 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
		s = " " + s;
//      将字符串转化为字符数组
		char[] chars = s.toCharArray();
//      建立next数组  
		int[] next = new int[len + 1];

		// 构造 next 数组过程，j从0开始(空格)，i从2开始
		for (int i = 2, j = 0; i <= len; i++) {
			// 匹配不成功，j回到前一位置 next 数组所对应的值
			while (j > 0 && chars[i] != chars[j + 1])
				j = next[j];
			// 匹配成功，j往后移
			if (chars[i] == chars[j + 1])
				j++;
			// 更新 next 数组的值
			next[i] = j;
		}
//      离上一个不匹配字符是否为最小字符串长度的倍数
		// 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
		if (next[len] > 0 && len % (len - next[len]) == 0) {
			return true;
		}
		return false;
	}
}