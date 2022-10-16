import java.util.Arrays;
import java.util.HashMap;

//哈希集合法
class Solution1 {
	public int[] smallerNumbersThanCurrent(int[] nums) {
//		定义哈希映射
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int[] res = new int[nums.length];
//		将数组复制进行排序，不能直接排序
		res = Arrays.copyOf(nums, nums.length);
		Arrays.sort(res);
//		将值和下标添加到映射
		for (int i = 0; i < res.length; i++) {
//			自小到大若存在则不添加
			if (!hashMap.containsKey(res[i])) {
				hashMap.put(res[i], i);
			}

		}
//		获取nums各值对应的下标
		for (int i = 0; i < res.length; i++) {
			res[i] = hashMap.get(nums[i]);
		}

		return res;

	}
}

//暴力法
//双重循环 时间复杂度n2
class Solution {
	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					res[i]++;
				}
			}
		}
		return res;

	}
}