import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public int[][] merge(int[][] intervals) {

//		一维整型数组链表
		List<int[]> result = new LinkedList<>();
//		按起始数字从小到大排序
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//		定义左边界
		int left = intervals[0][0];
//		定义右边界
		int right = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
//			若当前的左边界大于右边界
			if (intervals[i][0] > right) {
//				则添加上一个数组
				result.add(new int[] { left, right });
//				并将当前的左边界和右边界赋值
				left = intervals[i][0];
				right = intervals[i][1];
//			若存在交集，则取最大的右边界
			} else {
				right = Math.max(right, intervals[i][1]);
			}
		}
//		最后添加上最后的一个集合
		result.add(new int[] { left, right });
		return result.toArray(new int[result.size()][]);

	}
}