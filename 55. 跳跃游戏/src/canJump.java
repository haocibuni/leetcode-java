//̰���㷨
class Solution {
	public boolean canJump(int[] nums) {
//		������鳤��Ϊ1����ǰ�㼴Ϊ�յ�
		if (nums.length == 1) {
			return true;
		}
//		��Ծ���Ƿ�Χ
		int coverRange = 0;
//		����Ծ��Χ�ڸ�����Ծ��Χ
		for (int i = 0; i <= coverRange; i++) {
//			����򱣳���Ծ��Χ
			coverRange = Math.max(coverRange, nums[i] + i);
//			����Ծ��Χ�ܹ�������ﵽ���һ�����֣��򷵻�
			if (coverRange >= nums.length - 1) {
				return true;
			}

		}
		return false;

	}
}