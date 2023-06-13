class Solution {
	public int countSubstrings(String s) {
		int len = s.length();
		int res = 0, left, right;
		for (int i = 0; i < 2 * len - 1; i++) {
			left = i / 2;
			right = i / 2 + i % 2;
			while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
				res++;
			}
		}
		return res;

	}
}