import java.util.HashSet;
import java.util.List;

class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
//		建立集合，去除重复的物品
		HashSet<String> set = new HashSet<>(wordDict);
//		建立dp数组，表示字符串长度为i的话，是否可拆分为物品
		boolean[] valid = new boolean[s.length() + 1];
//		将初始状态设置为true
		valid[0] = true;
//		遍历背包
		for (int i = 1; i <= s.length(); i++) {
//			遍历物品，和状态为false的背包
			for (int j = 0; j < i && !valid[i]; j++) {
//				若物品种包含子字符串且前j个字符串为true，则设i为true
				if (set.contains(s.substring(j, i)) && valid[j]) {
					valid[i] = true;
				}
			}
		}

		return valid[s.length()];
	}
}