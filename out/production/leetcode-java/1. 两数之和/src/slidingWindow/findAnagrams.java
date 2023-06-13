package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAnagrams {
	public static List<Integer> solution(String s, String t) {
		HashMap<Character, Integer> needHashMap = new HashMap<>();
		HashMap<Character, Integer> windowHashMap = new HashMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		for (char c : t.toCharArray()) {
			needHashMap.put(c, needHashMap.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0;
		int valid = 0;
		int len = t.length();
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;
			if (needHashMap.containsKey(c)) {
				windowHashMap.put(c, windowHashMap.getOrDefault(c, 0) + 1);
				if (windowHashMap.get(c).equals(needHashMap.get(c))) {
					valid++;
				}
			}
			while (right - left == len) {
				if (valid == needHashMap.size()) {
					res.add(left);
				}
				char d = s.charAt(left);
				left++;
				if (needHashMap.containsKey(d)) {
					if (windowHashMap.get(d).equals(needHashMap.get(d))) {
						valid--;
					}
					windowHashMap.put(d, windowHashMap.get(d) - 1);
				}

			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(solution("cbaebabacd", "abc"));

	}
}
