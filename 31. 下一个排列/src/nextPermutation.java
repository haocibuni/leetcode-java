import java.util.Arrays;

class Solution {
	public void nextPermutation(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = nums.length - 1; j > i; j--) {

				if (nums[j] > nums[i]) {
					int temp;
					temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
					Arrays.sort(nums, i + 1, nums.length);
					return;
				}

			}
		}
		Arrays.sort(nums);
		return;

	}
}