class Solution {
	public int[] sortArrayByParityII(int[] nums) {
		// 定义结果数组 result
		int[] result = new int[nums.length];
		int even = 0, odd = 1;
		for (int i = 0; i < nums.length; i++) {
			// 如果为偶数
			if (nums[i] % 2 == 0) {
				result[even] = nums[i];
				even += 2;
			} else {
				result[odd] = nums[i];
				odd += 2;
			}
		}
		return result;
	}
}