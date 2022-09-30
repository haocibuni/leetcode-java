import java.util.ArrayList;
import java.util.List;

//���ݷ�
class Solution {
//	�������ַ��������ʱ����builder
	List<String> result = new ArrayList<>();
	StringBuilder temp = new StringBuilder();

	public List<String> letterCombinations(String digits) {
//		map�ַ����飺�±������ֶ�Ӧ
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
//		������Ӧ���ֶ�Ӧ����ĸ�ַ�����
		for (char c : numString[digits.charAt(num) - '0'].toCharArray()) {
//			builder����ַ�
			temp.append(c);
//			�ݹ���һ������
			backTracking(digits, numString, num + 1);
//			builderɾ���ַ�
			temp.deleteCharAt(temp.length() - 1);
		}

	}
}