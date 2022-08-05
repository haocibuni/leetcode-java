//双指针法 时间复杂度n 空间复杂度n
class Solution {
	public int[] sortedSquares(int[] nums) {
		int[] res = new int[nums.length];
		int k = nums.length - 1, i = 0, j = nums.length - 1;
//		结束条件为i>j
		while (i <= j) {
			if (nums[i] * nums[i] > nums[j] * nums[j]) {
				res[k--] = nums[i] * nums[i];
				i++;

			} else {
				res[k--] = nums[j] * nums[j];
				j--;

			}
		}
		return res;

	}
}