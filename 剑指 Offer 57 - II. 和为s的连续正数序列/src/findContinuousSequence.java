import java.util.ArrayList;

//滑动窗口法 时间复杂度n 空间复杂度1
//右起始边界i 左边界j
//当目标值小于sum，右边界左移
//当目标值大于sum，左边界右移
//当目标值等于sum，则将i- j-1的数加入到临时数组，并将临时数组添加到arraylist数组
//当右边界处于目标值中点时退出循环，因为中点值加任意右边的值都会大于目标值
class Solution {
	public int[][] findContinuousSequence(int target) {
		int i = 1, j = 1, sum = 0;
		ArrayList<int[]> res = new ArrayList<>();
		while (i <= target / 2) {
			if (sum < target) {
				sum = sum + j;
				j++;

			} else if (sum > target) {
				sum = sum - i;
				i++;
			} else {
				int[] temp = new int[j - i];
				for (int k = i; k < j; k++) {
					temp[k - i] = k;
				}
				res.add(temp);
				sum = sum - i;
				i++;
			}
		}
		return res.toArray(new int[res.size()][]);

	}
}