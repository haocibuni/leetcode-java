//�������ڷ� ʱ�临�Ӷ�n �ռ临�Ӷ�1
//forѭ����right������  while��left������
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
//		�ж��Ƿ��г���Ŀ��ֵ���Ӵ� ��û���򷵻�0
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}