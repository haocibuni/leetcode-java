//双指针法
class Solution {
	public boolean validMountainArray(int[] arr) {
//		若长度小于2 肯定不满足条件
		if (arr.length <= 2) {
			return false;
		}
//		定义左右指针下标
		int left = 0;
		int right = arr.length - 1;
//		边界限制
		while (left + 1 < arr.length - 1 && arr[left] < arr[left + 1]) {
			left++;
		}
		while (right > 0 && arr[right - 1] > arr[right]) {
			right--;
		}
//		到同一位置，且不在起点则满足条件
		if (left == right && left != 0 && right != arr.length - 1) {
			return true;
		}
		return false;
	}
}