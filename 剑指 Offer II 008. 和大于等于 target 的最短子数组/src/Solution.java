class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0, right = 0;
		int min = Integer.MAX_VALUE;
		int sum = nums[0];
		while (true) {
			if (left >= nums.length || right >= nums.length || left > right
					|| (left == right && right == nums.length - 1)) {
				break;
			}
			if (sum == target && left < nums.length) {
				min = Math.min(min, right - left + 1);
				sum -= nums[left];
				left++;

			}
			if (sum < target && right < nums.length - 1) {

				right++;
				sum += nums[right];

			}
			if (sum > target && left < nums.length) {
				sum -= nums[left];
				left++;

			}

		}
		return min;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(solution.minSubArrayLen(7, nums));
	}
}

class Solution1 {
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0, right = 0;
		int min = Integer.MAX_VALUE;
		int sum = nums[0];
		while (true) {
			if (left >= nums.length || right >= nums.length || left > right
					|| (left == right && right == nums.length - 1)) {
				break;
			}
			if (sum == target && left < nums.length) {
				min = Math.min(min, right - left + 1);
				sum -= nums[left];
				left++;

			}
			if (sum < target && right < nums.length - 1) {

				right++;
				sum += nums[right];

			}
			if (sum > target && left < nums.length) {
				sum -= nums[left];
				left++;

			}

		}
		return min;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(solution.minSubArrayLen(7, nums));
	}
}

class Solution2 {
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int res = Integer.MAX_VALUE;
		int sum = 0;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= target) {
				res = Math.min(res, right - left + 1);
				sum -= nums[left];
				left++;
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}