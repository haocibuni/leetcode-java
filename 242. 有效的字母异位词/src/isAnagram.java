//数组法 时间复杂度n 空间复杂度1
//小写字母-'a'=0-26的下标
//record表示下标和值的关系
class Solution {
	public boolean isAnagram(String s, String t) {
		int[] record = new int[26];
		for (char c : s.toCharArray()) {
			record[c - 'a'] += 1;
		}
		for (char c : t.toCharArray()) {
			record[c - 'a'] -= 1;
		}
		for (int i : record) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
}