//������ ����ѭ�� ʱ�临�Ӷ�n2
class Solution1 {
	public void moveZeroes(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				for (int j = i; j < nums.length; j++) {
					if (nums[j] != 0) {
						nums[i] = nums[j];
						nums[j] = 0;
						break;

					}
				}
			}

		}

	}
}

//˫ָ�뷨
class Solution {
	public void moveZeroes(int[] nums) {
		int slow = 0;
		for (int fast = 0; fast < nums.length; fast++) {
			if (nums[fast] != 0) {
				nums[slow] = nums[fast];
				slow++;
			}
		}
		for (int i = slow; i < nums.length; i++) {
			nums[i] = 0;
		}

	}
}