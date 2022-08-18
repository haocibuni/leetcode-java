//双指针法 时间复杂度n 空间复杂度1
//快指针指向目标元素 慢指针指向更新的下标
class Solution {
	public int removeElement(int[] nums, int val) {
		int fastindex = 0;
		int slowindex;
		for (slowindex = 0; fastindex < nums.length; fastindex++) {
			if (nums[fastindex] != val) {
				nums[slowindex] = nums[fastindex];
				slowindex++;
			}
		}
		return slowindex;

	}
}