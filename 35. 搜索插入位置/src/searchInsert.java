class Solution {
	public int searchInsert(int[] nums, int target) {
		if (nums != null) {
			return searchRecursion(nums, target, 0, nums.length - 1);
		}
		return -1;
	}

	private int searchRecursion(int[] nums, int target, int start, int end) {
		if (start > end) {
			return start;
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (target < nums[mid]) {
			return searchRecursion(nums, target, start, mid - 1);
		} else {
			return searchRecursion(nums, target, mid + 1, end);
		}
	}
}