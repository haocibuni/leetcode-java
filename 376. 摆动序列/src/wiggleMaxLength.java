//̰���㷨
class Solution {
	public int wiggleMaxLength(int[] nums) {
//		������1����Ĭ��ʹ��һ������Ϊ������
		if (nums.length <= 1) {
			return nums.length;
		}
//		��ǰ��ֵ
		int curDiff = 0;
//		��һ����ֵ
		int preDiff = 0;
//		���������ָ���
		int result = 1;
		for (int i = 1; i < nums.length; i++) {

			curDiff = nums[i] - nums[i - 1];
//			����ǰ��ֵ����һ����ֵһ��һ�������������У�������ǰ��ֵ��ֵΪ��һ����ֵ
			if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {

				result++;
				preDiff = curDiff;
			}

		}
		return result;

	}
}