//�����ɹ������±����� ʱ�临�Ӷ�n2
class Solution_exchange {
	public int[] exchange(int[] nums) {
		if (nums.length == 0) {
			return nums;
		}
		boolean flag = false;
		int temp = nums[0], index = 0;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] % 2 == 0 && flag == false) {

				temp = nums[i];
				index = i;
				flag = true;
			}
			if (nums[i] % 2 != 0 && flag == true) {

				nums[index] = nums[i];
				nums[i] = temp;
				flag = false;
				i = index;

			}
		}
		return nums;

	}
}

//˫��ָ�뷨  ʱ�临�Ӷ�n �ռ临�Ӷ�1
//�ж���ż num&1==1Ϊ���� num&1==0Ϊż��
class Solution_deque {
	public int[] exchange(int[] nums) {
		int i = 0, j = nums.length - 1, temp;
		while (i < j) {
			while (i < j && (nums[i] % 2) != 0) {
				i++;
			}
			while (i < j && (nums[j] % 2) == 0) {
				j--;
			}

			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		return nums;

	}
}