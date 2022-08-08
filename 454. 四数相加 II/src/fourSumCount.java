import java.util.HashMap;
import java.util.Map;

//哈希映射法 时间复杂度n2 空间复杂度n
//key表示前两个数组的各数之和，value表示各数之和的个数
//然后计算后两个数组的各数之和的相反数，
//验证是否存在于hashmap中
class Solution {
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> hasMap = new HashMap<Integer, Integer>();
		int sum;
		int res = 0;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				sum = nums1[i] + nums2[j];
				if (hasMap.containsKey(sum)) {
					hasMap.put(sum, hasMap.get(sum) + 1);
				} else {
					hasMap.put(sum, 1);
				}
			}
		}
		for (int i = 0; i < nums3.length; i++) {
			for (int j = 0; j < nums4.length; j++) {
				sum = -(nums3[i] + nums4[j]);
				if (hasMap.containsKey(sum)) {
					res += hasMap.get(sum);
				}
			}
		}
		return res;
	}
}