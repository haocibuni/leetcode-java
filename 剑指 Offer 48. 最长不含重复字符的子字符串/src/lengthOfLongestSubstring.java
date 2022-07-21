import java.util.HashMap;
import java.util.Map;

//动态规划 + 哈希表法 时间复杂度n 空间复杂度1
//dp[j]表示以字符s[j]结尾的最长字符串的长度
//固定右边界j后然后找到j左侧最近的相同字符索引为i
//如果字符 s[ i ] 在子字符串 sub[ j − 1 ] 区间之外，也就是更左侧, 那么dp[ j - 1 ] < j - i，
//这种情况下，由于sub [ j - 1]中字符不重复，且当前最长，所以以s[ j ]为结尾的字符串只需要在子字符串 sub[ j − 1 ]后面接上这个字符s[ j ]就可以了，其长度dp [ j ] = dp[ j - 1 ] + 1;
//如果字符 s[ i ] 在子字符串 sub[ j− 1 ] 区间之中，必然dp[ j−1 ] ≥ j − i，
//这种情况下，由于我们需要寻找以s[ j ]结尾且最长的字符串，那么sub[ j ]的左边界只能是 i 了，其长度 dp[ j ] = j − i 。
class Solution {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int res = 0, temp = 0;
		for (int j = 0; j < s.length(); j++) {
//			获取哈希表键对应的值，若没有则返回固定值
			int i = map.getOrDefault(s.charAt(j), -1);
			map.put(s.charAt(j), j);
			temp = temp < j - i ? temp + 1 : j - i;
			res = Math.max(res, temp);
		}
		return res;

	}
}