import java.util.HashMap;
import java.util.Map;

class Solution {
	// ��ϣӳ�䷨
	public boolean canConstruct_hashmap(String ransomNote, String magazine) {
		Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (char c : magazine.toCharArray()) {
			if (hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c) + 1);
			} else {
				hashMap.put(c, 1);
			}
		}
		for (char c : ransomNote.toCharArray()) {
			if (hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c) - 1);
			} else {
				return false;
			}
		}
		for (int i : hashMap.values()) {
			if (i < 0) {
				return false;
			}
		}
		return true;
	}

//	���鷨 
	public boolean canConstruct_list(String ransomNote, String magazine) {
		// ����һ����ϣӳ������
		int[] record = new int[26];

		// ����
		for (char c : magazine.toCharArray()) {
			record[c - 'a'] += 1;
		}

		for (char c : ransomNote.toCharArray()) {
			record[c - 'a'] -= 1;
		}

		// ��������д��ڸ�����˵��ransomNote�ַ����ܴ���magazine��û�е��ַ�
		for (int i : record) {
			if (i < 0) {
				return false;
			}
		}

		return true;
	}
}
