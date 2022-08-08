//���鷨 ʱ�临�Ӷ�n �ռ临�Ӷ�1
//Сд��ĸ-'a'=0-26���±�
//record��ʾ�±��ֵ�Ĺ�ϵ
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