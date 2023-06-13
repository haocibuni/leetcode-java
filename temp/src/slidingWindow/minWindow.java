package slidingWindow;

import java.util.HashMap;

public class minWindow {
	public static String minString(String s, String t) {
		HashMap<Character, Integer> needHashMap = new HashMap<>();
		HashMap<Character, Integer> windowHashMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			needHashMap.put(c, needHashMap.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0;
		int valid = 0;
		int start = 0, len = Integer.MAX_VALUE;
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;
			windowHashMap.put(c, windowHashMap.getOrDefault(c, 0) + 1);
			if (needHashMap.containsKey(c)) {

				if (windowHashMap.get(c).equals(needHashMap.get(c))) {
					valid++;
				}
			}
			while (valid == needHashMap.size()) {
				if (right - left < len) {
					start = left;
					len = right - left;
				}
				char d = s.charAt(left);
				left++;

				if (needHashMap.containsKey(d)) {
					if (windowHashMap.get(d).equals(needHashMap.get(d))) {
						valid--;
					}

				}
				windowHashMap.put(d, windowHashMap.get(d) - 1);
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

	}

	public static void main(String[] args) {
		System.out.println(minString("EBBANCF", "ABC"));

	}
}
