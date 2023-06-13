import java.util.HashMap;

class Solution {
	public int findMaxLength(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = -1;
			}
		}
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(0, -1);
		int pre = 0;
		for (int i = 0; i < nums.length; i++) {
			pre += nums[i];
			if (hashMap.containsKey(pre)) {
				res = Math.max(res, i - hashMap.get(pre));
			} else {
				hashMap.put(pre, i);
			}

		}
		return res;
	}
}

class Solution1 {
	public int findMaxLength(int[] nums) {
		int sum = 0;
		int res = 0;
		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (left <= right && sum >= (right - left + 1) / 2 && sum != 0) {
				if (sum == (right - left + 1) / 2) {
					res = Math.max(res, right - left + 1);
				}
				sum -= nums[left++];
			}
		}
		return res;
	}
}
