class Solution {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int left = 0;
		int res = 0;
		int product = 1;
		for (int right = 0; right < nums.length; right++) {
			product *= nums[right];
			while (left <= right && product >= k) {

				product = product / nums[left];
				left++;
			}
			res += right - left + 1;
		}
		return res;
	}
}