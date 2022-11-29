import java.util.HashMap;
import java.util.Set;

class Solution {
	public int maxProduct(String[] words) {
		int[] mask = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			char[] word = words[i].toCharArray();
			for (int j = 0; j < word.length; j++) {
				mask[i] |= 1 << word[j] - 'a';
			}
		}
		int res = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if ((mask[i] & mask[j]) == 0) {
					res = Math.max(res, words[i].length() * words[j].length());
				}
			}
		}
		return res;

	}

}

class Solution1 {
	public int maxProduct(String[] words) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int length = words.length;
		for (int i = 0; i < length; i++) {
			int mask = 0;
			String word = words[i];
			int wordLength = word.length();
			for (int j = 0; j < wordLength; j++) {
				mask |= 1 << (word.charAt(j) - 'a');
			}
			if (wordLength > map.getOrDefault(mask, 0)) {
				map.put(mask, wordLength);
			}
		}
		int maxProd = 0;
		Set<Integer> maskSet = map.keySet();
		for (int mask1 : maskSet) {
			int wordLength1 = map.get(mask1);
			for (int mask2 : maskSet) {
				if ((mask1 & mask2) == 0) {
					int wordLength2 = map.get(mask2);
					maxProd = Math.max(maxProd, wordLength1 * wordLength2);
				}
			}
		}
		return maxProd;
	}
}
