//滑动窗口法 时间复杂度n 空间复杂度1
//for循环让right往右走  while让left往右走
class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int sum = 0;
		int left = 0;
		int res = Integer.MAX_VALUE;
		for (int right = 0; right < nums.length; right++) {
			sum = sum + nums[right];
			while (sum >= target) {
				res = Math.min(res, right - left + 1);
				sum = sum - nums[left];
				left++;
			}
		}
//		判断是否有超过目标值的子串 若没有则返回0
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}