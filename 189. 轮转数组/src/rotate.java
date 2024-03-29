class Solution {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k);
		reverse(nums, k, nums.length - 1);

	}

	public void reverse(int[] nums, int start, int end) {
		int temp;
		for (int i = start, j = end; i < j; i++, j--) {
			temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}
	}
}