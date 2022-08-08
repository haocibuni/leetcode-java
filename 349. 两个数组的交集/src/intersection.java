import java.util.HashSet;
import java.util.Set;

//哈希集合法 时间复杂度n 空间复杂度n
//通过两个哈希集合来获取两个数组的交集 第一个集合为第一个数组的交集
class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> res = new HashSet<>();
		for (int i : nums1) {
			set1.add(i);
		}
		for (int i : nums2) {
			if (set1.contains(i)) {
				res.add(i);
			}
		}
		return res.stream().mapToInt(x -> x).toArray();
	}
}