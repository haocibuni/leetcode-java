//̰���㷨
class Solution {
	public int jump(int[] nums) {
//		������Ϊ�ջ����鳤��Ϊ0�����鳤��Ϊ1����Ҫ��Ծ
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
//		��󸲸Ƿ�Χ
		int maxCoverRange = 0;
//		��ǰ���Ƿ�Χ
		int curCoverRange = 0;
//		��Ծ����
		int count = 0;
//		������Ծ
		for (int i = 0; i < nums.length; i++) {
//			��󸲸Ƿ�Χ����
			maxCoverRange = Math.max(maxCoverRange, nums[i] + i);
//			����󸲸Ƿ�Χ���ǵ��յ㣬��ֻ������һ������
			if (maxCoverRange >= nums.length - 1) {
				count++;
				return count;
			}
//			����ƶ��±�ﵽ�˵�ǰ��һ������󸲸���Զ�����ˣ���û�е��յ�Ļ�����ô�ͱ�������һ�������Ӹ��Ƿ�Χ��ֱ�����Ƿ�Χ�������յ㡣
			if (i == curCoverRange) {
				curCoverRange = maxCoverRange;
				count++;
			}
		}
		return count;

	}
}