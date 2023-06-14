import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		int n = s.length(), m = p.length();
		List<Integer> res = new ArrayList<>();
		if (n < m) {
			return res;
		}
		int[] cnum = new int[26];
		for (int i = 0; i < m; i++) {
			cnum[s.charAt(i) - 'a']++;
			cnum[p.charAt(i) - 'a']--;
		}
		int diff = 0;
		for (int i : cnum) {
			if (i != 0) {
				diff++;
			}
		}
		if (diff == 0) {
			res.add(0);
		}
		for (int i = m; i < n; i++) {
			int add = s.charAt(i) - 'a', del = s.charAt(i - m) - 'a';
			if (add == del) {
				continue;
			}
			if (cnum[add] == 0) {
				diff++;
			}
			cnum[add]++;
			if (cnum[add] == 0) {
				diff--;
			}
			if (cnum[del] == 0) {
				diff++;
			}
			cnum[del]--;
			if (cnum[del] == 0) {
				diff--;
			}
			if (diff == 0) {
				res.add(i - m + 1);
			}
		}
		return res;

	}
}