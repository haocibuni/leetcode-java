import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//哈希表法 时间复杂度n 空间复杂度1
//哈希字典表示的为字符和字符出现的次数
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

//哈希表法 时间复杂度n 空间复杂度1
//哈希字典表示的为字符和该字符是否只存在一次
class Solution_hash_boolean {
	public char firstUniqChar(String s) {
		HashMap<Character, Boolean> dic = new HashMap<>();
		char[] sc = s.toCharArray();
		for (char c : sc)
//			关键点
			dic.put(c, !dic.containsKey(c));
		for (char c : sc)
			if (dic.get(c))
				return c;
		return ' ';
	}
}

//哈希表法 时间复杂度n 空间复杂度1
//有序哈希表的键值对是按照插入顺序排序的
//所以通过遍历哈希表即可，避免字符串过长时的第二轮循环次数
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
