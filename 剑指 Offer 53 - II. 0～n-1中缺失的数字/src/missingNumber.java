//���ֲ��ҷ� ʱ�临�Ӷ�logn �ռ临�Ӷ�1
//������ֵ���������Ӧ������ֵ������е�ǰ���������ȱʧ
//���������ʾȱʧ���� ���������ʾ��ȱʧ���� 
//i��ʾ�����������λԪ�� j��ʾ���������ĩλԪ��
class Solution_binary {
	public int missingNumber(int[] nums) {
		int i = 0, j = nums.length - 1;
		while (i <= j) {
			int m = (i + j) / 2;
			if (nums[m] == m) {
				i = m + 1;
			} else {
				j = m - 1;
			}
		}
		return i;
	}
}