//hashmap�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//˫ָ�뷨 ʱ�临�Ӷ�n �ռ临�Ӷ�1
//˫ָ��ָ�����������
//���м���ң���С��Ŀ����i++ ������Ŀ����j--
class Solution {
	public int[] twoSum(int[] nums, int target) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int s = nums[i] + nums[j];
			if (s < target)
				i++;
			else if (s > target)
				j--;
			else
				return new int[] { nums[i], nums[j] };
		}
		return new int[0];
	}
}
