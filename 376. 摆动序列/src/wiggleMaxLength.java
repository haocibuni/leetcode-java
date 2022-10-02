//贪心算法
class Solution {
	public int wiggleMaxLength(int[] nums) {
//		若等于1，则默认使第一个数作为子序列
		if (nums.length <= 1) {
			return nums.length;
		}
//		当前插值
		int curDiff = 0;
//		上一个插值
		int preDiff = 0;
//		子序列数字个数
		int result = 1;
		for (int i = 1; i < nums.length; i++) {

			curDiff = nums[i] - nums[i - 1];
//			若当前插值和上一个插值一正一负则增加子序列，并将当前差值赋值为上一个插值
			if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {

				result++;
				preDiff = curDiff;
			}

		}
		return result;

	}
}