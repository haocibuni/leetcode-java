class Solution {
	public boolean backspaceCompare(String s, String t) {
		StringBuilder stringBuilder1 = new StringBuilder();
		StringBuilder stringBuilder2 = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c != '#') {
				stringBuilder1.append(c);
			} else if (stringBuilder1.length() > 0) {
				stringBuilder1.deleteCharAt(stringBuilder1.length() - 1);
			}
		}
		for (char c : t.toCharArray()) {
			if (c != '#') {
				stringBuilder2.append(c);
			} else if (stringBuilder2.length() > 0) {
				stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
			}
		}
//		必须转换为string才能使用equals函数
		return stringBuilder1.toString().equals(stringBuilder2.toString());

	}
}