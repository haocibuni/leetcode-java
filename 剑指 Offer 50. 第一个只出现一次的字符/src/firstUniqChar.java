import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//��ϣ�� ʱ�临�Ӷ�n �ռ临�Ӷ�1
//��ϣ�ֵ��ʾ��Ϊ�ַ����ַ����ֵĴ���
class Solution_hash {
	public char firstUniqChar(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				map.replace(chars[i], map.get(chars[i]) + 1);
			} else {
				map.put(chars[i], 1);
			}
		}
		for (char c : chars) {
			if (map.get(c) == 1) {
				return c;
			}
		}
		return ' ';
	}
}

//��ϣ�� ʱ�临�Ӷ�n �ռ临�Ӷ�1
//��ϣ�ֵ��ʾ��Ϊ�ַ��͸��ַ��Ƿ�ֻ����һ��
class Solution_hash_boolean {
	public char firstUniqChar(String s) {
		HashMap<Character, Boolean> dic = new HashMap<>();
		char[] sc = s.toCharArray();
		for (char c : sc)
//			�ؼ���
			dic.put(c, !dic.containsKey(c));
		for (char c : sc)
			if (dic.get(c))
				return c;
		return ' ';
	}
}

//��ϣ�� ʱ�临�Ӷ�n �ռ临�Ӷ�1
//�����ϣ��ļ�ֵ���ǰ��ղ���˳�������
//����ͨ��������ϣ���ɣ������ַ�������ʱ�ĵڶ���ѭ������
class Solution {
	public char firstUniqChar(String s) {
		Map<Character, Boolean> dic = new LinkedHashMap<>();
		char[] sc = s.toCharArray();
		for (char c : sc)
			dic.put(c, !dic.containsKey(c));
		for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
			if (d.getValue())
				return d.getKey();
		}
		return ' ';
	}
}
