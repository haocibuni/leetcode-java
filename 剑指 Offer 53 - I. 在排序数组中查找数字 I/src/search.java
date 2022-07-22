//暴力法 时间复杂度n 空间复杂度1
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

//二分查找法 时间复杂度logn 空间复杂度1
//通过二分法寻找左边界和右边界
//右边界为 nums[i]>target
//左边界为nums[j]<target
//每次循环结束后ij都不重合
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