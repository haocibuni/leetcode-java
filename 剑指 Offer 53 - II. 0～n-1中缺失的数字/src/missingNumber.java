//二分查找法 时间复杂度logn 空间复杂度1
//若索引值等于数组对应索引的值则表明中点前面的数字无缺失
//右子数组表示缺失数组 左子数组表示无缺失数组 
//i表示右子数组的首位元素 j表示左子数组的末位元素
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