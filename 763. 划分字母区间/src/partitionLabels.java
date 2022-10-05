import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> partitionLabels(String s) {
//		一维整型结果数组
		List<Integer> result = new ArrayList<>();
//		26个字母最后一个的下标
		int[] edge = new int[26];
//		将字符串转化为字符数组
		char[] chars = s.toCharArray();
//		遍历各字母的最后下标
		for (int i = 0; i < chars.length; i++) {
			edge[chars[i] - 'a'] = i;
		}
		int idx = 0;
		int last = -1;
//		从头遍历字符串，更新当前最大的最后下标
		for (int i = 0; i < chars.length; i++) {

			idx = Math.max(idx, edge[chars[i] - 'a']);
//			若当前最大的最后下标等于当前下标则添加
			if (idx == i) {
				result.add(i - last);
				last = i;
			}
		}
		return result;
	}
}