//交换成功后重新遍历法 时间复杂度n2
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

//双端指针法  时间复杂度n 空间复杂度1
//判断奇偶 num&1==1为奇数 num&1==0为偶数
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