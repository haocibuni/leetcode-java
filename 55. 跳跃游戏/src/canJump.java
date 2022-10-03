//贪心算法
class Solution {
	public boolean canJump(int[] nums) {
//		如果数组长度为1，则当前点即为终点
		if (nums.length == 1) {
			return true;
		}
//		跳跃覆盖范围
		int coverRange = 0;
//		在跳跃范围内更新跳跃范围
		for (int i = 0; i <= coverRange; i++) {
//			扩大或保持跳跃范围
			coverRange = Math.max(coverRange, nums[i] + i);
//			若跳跃范围能够超过或达到最后一个数字，则返回
			if (coverRange >= nums.length - 1) {
				return true;
			}

		}
		return false;

	}
}