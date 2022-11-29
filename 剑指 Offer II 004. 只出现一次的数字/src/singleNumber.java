import java.util.HashMap;
import java.util.Map;

class Solution {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Boolean> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(nums[i])) {
				hashMap.put(nums[i], false);
			} else {
				hashMap.put(nums[i], true);
			}
		}
		for (Map.Entry<Integer, Boolean> entry : hashMap.entrySet()) {
			if (entry.getValue()) {
				return entry.getKey();

			}
		}
		return -1;

	}
}

class Solution1 {
	public int singleNumber(int[] nums) {
		int res = 0;
		int count;
		for (int i = 0; i < 32; i++) {
			count = 0;
			for (int num : nums) {
				count += (num >> i) & 1;
			}
			if (count % 3 != 0) {
				res |= (1 << i);
			}
		}
		return res;

	}
}