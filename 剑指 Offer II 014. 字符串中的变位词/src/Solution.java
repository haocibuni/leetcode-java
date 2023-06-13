import java.util.HashSet;

class Solution1 {
	HashSet<String> hashSet;
	char[] chars;

	public boolean checkInclusion(String s1, String s2) {
		hashSet = new HashSet<>();
		chars = s1.toCharArray();
		dfs(0);

		for (int i = 0; i < s2.length(); i++) {
			if (i + s1.length() <= s2.length() && hashSet.contains(s2.substring(i, i + s1.length()))) {
				return true;
			}
		}
		return false;
	}

	public void dfs(int index) {
		if (index == chars.length - 1 && !hashSet.contains(String.valueOf(chars))) {

			hashSet.add(String.valueOf(chars));
			return;
		}
		HashSet<Character> charhashSet = new HashSet<>();
		for (int i = index; i < chars.length; i++) {
			if (charhashSet.contains(chars[i])) {
				continue;
			}
			swap(chars, index, i);
			dfs(index + 1);
			swap(chars, index, i);
		}
	}

	public void swap(char[] chars, int index1, int index2) {
		char temp = chars[index1];
		chars[index1] = chars[index2];
		chars[index2] = temp;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.checkInclusion("ab", "eidbaooo"));

	}
}

class Solution {

	public boolean checkInclusion(String s1, String s2) {
		int n = s1.length(), m = s2.length();
		if (n > m) {
			return false;
		}
		int[] count = new int[26];
		for (int i = 0; i < n; i++) {
			count[s1.charAt(i) - 'a']--;
			count[s2.charAt(i) - 'a']++;
		}
		int diff = 0;
		for (int i : count) {
			if (i != 0) {
				diff++;
			}
		}
		if (diff == 0) {
			return true;
		}
		for (int i = n; i < m; i++) {
			int del = s2.charAt(i - n) - 'a', add = s2.charAt(i) - 'a';
			if (del == add) {
				continue;
			}
			if (count[add] == 0) {
				diff++;
			}
			count[add]++;
			if (count[add] == 0) {
				diff--;
			}
			if (count[del] == 0) {
				diff++;
			}
			count[del]--;
			if (count[del] == 0) {
				diff--;
			}
			if (diff == 0) {
				return true;
			}
		}
		return false;
	}

}