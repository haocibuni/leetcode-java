import java.util.HashMap;
import java.util.Map;

class Solution {
	// 哈希映射法
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

//	数组法 
	public boolean canConstruct_list(String ransomNote, String magazine) {
		// 定义一个哈希映射数组
		int[] record = new int[26];

		// 遍历
		for (char c : magazine.toCharArray()) {
			record[c - 'a'] += 1;
		}

		for (char c : ransomNote.toCharArray()) {
			record[c - 'a'] -= 1;
		}

		// 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
		for (int i : record) {
			if (i < 0) {
				return false;
			}
		}

		return true;
	}
}
