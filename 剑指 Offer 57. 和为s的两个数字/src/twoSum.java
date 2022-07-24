//hashmap法 时间复杂度n 空间复杂度n
//双指针法 时间复杂度n 空间复杂度1
//双指针指向数组的两端
//向中间查找，若小于目标则i++ 若大于目标则j--
class Solution {
	public int[] twoSum(int[] nums, int target) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int s = nums[i] + nums[j];
			if (s < target)
				i++;
			else if (s > target)
				j--;
			else
				return new int[] { nums[i], nums[j] };
		}
		return new int[0];
	}
}
