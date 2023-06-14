import java.util.HashMap;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		int res = 0, index, dp = 0;
		for (int i = 0; i < s.length(); i++) {
			index = hashMap.getOrDefault(s.charAt(i), -1);
			dp = i - index <= dp ? i - index : dp + 1;
			res = Math.max(dp, res);
			hashMap.put(s.charAt(i), i);
		}
		return res;
	}
}