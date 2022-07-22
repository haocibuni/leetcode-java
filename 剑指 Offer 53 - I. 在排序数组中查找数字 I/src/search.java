//������ ʱ�临�Ӷ�n �ռ临�Ӷ�1
class Solution_force {
	public int search(int[] nums, int target) {
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				count++;
				flag = true;
			}
			if (flag && nums[i] != target) {
				break;
			}
		}
		return count;
	}
}

//���ֲ��ҷ� ʱ�临�Ӷ�logn �ռ临�Ӷ�1
//ͨ�����ַ�Ѱ����߽���ұ߽�
//�ұ߽�Ϊ nums[i]>target
//��߽�Ϊnums[j]<target
//ÿ��ѭ��������ij�����غ�
class Solution_binary {
	public int search(int[] nums, int target) {
		int i = 0, j = nums.length - 1;

		while (i <= j) {
			int m = (i + j) / 2;
			if (nums[m] <= target) {
				i = m + 1;
			} else {
				j = m - 1;
			}
		}
		int right = i;
		if (j >= 0 && nums[j] != target) {
			return 0;
		}
		i = 0;
		j = nums.length - 1;
		while (i <= j) {
			int m = (i + j) / 2;
			if (nums[m] >= target) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}
		int left = j;
		return right - left - 1;
	}
}