class Solution {
	public int maxSubArray(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
//		�ܺ�
		int sum = Integer.MIN_VALUE;
//		��ǰ����
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i];
			sum = Math.max(sum, count); // ȡ�����ۼƵ����ֵ���൱�ڲ���ȷ�����������ֹλ�ã�
			if (count <= 0) {
				count = 0; // �൱���������������ʼλ�ã���Ϊ��������һ���������ܺ�
			}
		}
		return sum;
	}
}