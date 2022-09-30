import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
//	二维字符串数组
	List<List<String>> result = new ArrayList<>();
//	一位字符串链表
	List<String> temp = new LinkedList<>();

	public List<List<String>> partition(String s) {
		backTracking(s, 0);
		return result;
	}

	public void backTracking(String s, int startIndex) {
//		若开始索引遍历到字符串末尾，则深拷贝temp链表
		if (startIndex == s.length()) {
			result.add(new ArrayList<>(temp));
			return;
		}
//		从startIndex开始遍历
		for (int i = startIndex; i < s.length(); i++) {
//			若从startindex到i为回文串
			if (isPalindrome(s, startIndex, i)) {
//				则在数组中添加该子串
				temp.add(s.substring(startIndex, i + 1));
//				递归下一层，进行切割
				backTracking(s, i + 1);
//				回溯
				temp.remove(temp.size() - 1);
			} else {
//				若不为回文串则直接跳过,下一个可能是
				continue;
			}
		}
	}

	public boolean isPalindrome(String s, int startIndex, int end) {
		for (int i = startIndex, j = end; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}