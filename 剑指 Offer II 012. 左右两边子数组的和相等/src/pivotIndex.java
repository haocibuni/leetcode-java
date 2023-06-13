class Solution {
	public int pivotIndex(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int pre = 0;
		for (int i = 0; i < nums.length; i++) {
			if (pre == sum - pre - nums[i]) {
				return i;
			}
			pre += nums[i];
		}
		return -1;

	}
}