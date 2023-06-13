package slidingWindow;

import java.util.HashMap;

public class lengthOfLongestSubstring {
	public static int solution(String s) {
		HashMap<Character, Integer> windowHashMap = new HashMap<>();
		int left = 0, right = 0;
		int res = Integer.MIN_VALUE;
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;
			windowHashMap.put(c, windowHashMap.getOrDefault(c, 0) + 1);

			while (windowHashMap.get(c) > 1) {
				char d = s.charAt(left);
				left++;
				windowHashMap.put(d, windowHashMap.get(d) - 1);
			}
			res = Math.max(res, right - left);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(solution("aabab"));

	}
}
