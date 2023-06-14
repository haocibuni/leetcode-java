import java.util.HashMap;

class Solution {
	public int subarraySum(int[] nums, int k) {
		int left = 0;
		int res = 0;
		int sum = 0;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (left <= right && sum >= k) {
				if (sum == k) {
					res++;
				}
				sum -= nums[left];
			}
		}
		return res;

	}
}

class Solution1 {
	public int subarraySum(int[] nums, int k) {
		int res = 0;
		int sum;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j >= 0; j--) {
				sum += nums[j];
				if (sum == k) {
					res++;
				}
			}
		}
		return res;

	}
}

class Solution2 {
	public int subarraySum(int[] nums, int k) {

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int pre = 0;
		int res = 0;
		hashMap.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			pre += nums[i];
			if (hashMap.containsKey(pre - k)) {
				res += hashMap.get(pre - k);
			}
			hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
		}
		return res;

	}
}