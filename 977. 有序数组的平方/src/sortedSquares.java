//˫ָ�뷨 ʱ�临�Ӷ�n �ռ临�Ӷ�n
class Solution {
	public int[] sortedSquares(int[] nums) {
		int[] res = new int[nums.length];
		int k = nums.length - 1, i = 0, j = nums.length - 1;
//		��������Ϊi>j
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