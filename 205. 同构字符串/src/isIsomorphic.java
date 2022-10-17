import java.util.HashMap;

//错误，统计s和t各字母出现的频率，再依次比较
class Solution1 {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		HashMap<Character, Integer> hashMap1 = new HashMap<>();
		HashMap<Character, Integer> hashMap2 = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!hashMap1.containsKey(s.charAt(i))) {
				hashMap1.put(s.charAt(i), 1);
			} else {
				hashMap1.put(s.charAt(i), hashMap1.get(s.charAt(i)) + 1);
			}
			if (!hashMap2.containsKey(t.charAt(i))) {
				hashMap2.put(t.charAt(i), 1);
			} else {
				hashMap2.put(t.charAt(i), hashMap2.get(t.charAt(i)) + 1);
			}

		}
		for (int i = 0; i < s.length(); i++) {
			if (hashMap1.get(s.charAt(i)) != hashMap2.get(t.charAt(i))) {
				return false;
			}
		}
		return true;

	}
}

class Solution {
	public boolean isIsomorphic(String s, String t) {
		char[] chars = s.toCharArray();
		char[] chart = t.toCharArray();
//		字符对应的最后出现次数
		int[] preIndexOfs = new int[256];
		int[] preIndexOft = new int[256];
		for (int i = 0; i < chars.length; i++) {
			if (preIndexOfs[chars[i]] != preIndexOft[chart[i]]) {
				return false;
			}
			preIndexOfs[chars[i]] = i + 1;
			preIndexOft[chart[i]] = i + 1;
		}
		return true;
	}
}