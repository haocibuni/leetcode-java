import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
//	��ά�ַ�������
	List<List<String>> result = new ArrayList<>();
//	һλ�ַ�������
	List<String> temp = new LinkedList<>();

	public List<List<String>> partition(String s) {
		backTracking(s, 0);
		return result;
	}

	public void backTracking(String s, int startIndex) {
//		����ʼ�����������ַ���ĩβ�������temp����
		if (startIndex == s.length()) {
			result.add(new ArrayList<>(temp));
			return;
		}
//		��startIndex��ʼ����
		for (int i = startIndex; i < s.length(); i++) {
//			����startindex��iΪ���Ĵ�
			if (isPalindrome(s, startIndex, i)) {
//				������������Ӹ��Ӵ�
				temp.add(s.substring(startIndex, i + 1));
//				�ݹ���һ�㣬�����и�
				backTracking(s, i + 1);
//				����
				temp.remove(temp.size() - 1);
			} else {
//				����Ϊ���Ĵ���ֱ������,��һ��������
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