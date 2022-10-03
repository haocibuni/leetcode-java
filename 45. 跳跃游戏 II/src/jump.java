//贪心算法
class Solution {
	public int jump(int[] nums) {
//		若数组为空或数组长度为0或数组长度为1则不需要跳跃
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
//		最大覆盖范围
		int maxCoverRange = 0;
//		当前覆盖范围
		int curCoverRange = 0;
//		跳跃次数
		int count = 0;
//		依次跳跃
		for (int i = 0; i < nums.length; i++) {
//			最大覆盖范围更新
			maxCoverRange = Math.max(maxCoverRange, nums[i] + i);
//			若最大覆盖范围覆盖到终点，则只需再跳一步即可
			if (maxCoverRange >= nums.length - 1) {
				count++;
				return count;
			}
//			如果移动下标达到了当前这一步的最大覆盖最远距离了，还没有到终点的话，那么就必须再走一步来增加覆盖范围，直到覆盖范围覆盖了终点。
			if (i == curCoverRange) {
				curCoverRange = maxCoverRange;
				count++;
			}
		}
		return count;

	}
}