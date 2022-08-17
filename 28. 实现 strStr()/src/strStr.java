//滑动窗口法 时间复杂度mn 空间复杂度1
class Solution_doublepoint {
	/**
	 * 基于窗口滑动的算法
	 * <p>
	 * 时间复杂度：O(m*n) 空间复杂度：O(1) 注：n为haystack的长度，m为needle的长度
	 */
	public int strStr(String haystack, String needle) {
		int m = needle.length();
		// 当 needle 是空字符串时我们应当返回 0
		if (m == 0) {
			return 0;
		}
//		当模式串大于字符串时 返回-1
		int n = haystack.length();
		if (n < m) {
			return -1;
		}
//		i代表字符串下标，j代表模式串下标
		int i = 0;
		int j = 0;
		while (i < n - m + 1) {
			// 找到首字母相等
			while (i < n && haystack.charAt(i) != needle.charAt(j)) {
				i++;
			}
			// 没有首字母相等的时候 返回-1
			if (i == n) {
				return -1;
			}
			// 遍历后续字符，判断是否相等
			i++;
			j++;
			while (i < n && j < m && haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			}
			// 若找到即模式串遍历到头，返回下标差值
			if (j == m) {
				return i - j;
				// 若未找到则字符串下标返回上次j位置，模式串下标返回0
			} else {
				i -= j - 1;
				j = 0;
			}
		}
		return -1;
	}
}

//前缀表法 时间复杂度mn 空间复杂度1
class Solution_next {
	public void getNext(int[] next, String s) {
//		前缀下标j后缀下标i
		int j = -1;
		next[0] = j;
//		从1开始遍历
		for (int i = 1; i < s.length(); i++) {
//			若前后缀不等，则j下标回退
			while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
				j = next[j];
			}
// 			若前后缀相等，则j++
			if (s.charAt(i) == s.charAt(j + 1)) {
				j++;
			}
//			然后把j复制到i
			next[i] = j;
//			i++
		}
	}

	public int strStr(String haystack, String needle) {
//		若模式串长度为0则返回0
		if (needle.length() == 0) {
			return 0;
		}
//      定义next数组，大小等于模式串大小
		int[] next = new int[needle.length()];
//		获取next数组
		getNext(next, needle);
		int j = -1;
//		遍历字符串
		for (int i = 0; i < haystack.length(); i++) {
//			若字母不相等则模式串下标根据next数组进行回退
			while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
				j = next[j];
			}
//			若字母相等则模式串下标j++
			if (haystack.charAt(i) == needle.charAt(j + 1)) {
				j++;
			}
//			若j到达模式串尾部则返回长度
			if (j == needle.length() - 1) {
				return (i - needle.length() + 1);
			}
		}

		return -1;
	}
}