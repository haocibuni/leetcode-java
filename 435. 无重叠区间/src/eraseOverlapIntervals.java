import java.util.Arrays;

class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
//		至少射出一箭
		int count = 0;
		int leftEdge = Integer.MIN_VALUE;
//		遍历范围
		for (int i = 0; i < intervals.length; i++) {
//			若当前射出的箭左边界跟上一箭的右边界不重叠，则需要再射一箭
			if (leftEdge <= intervals[i][0]) {
				leftEdge = intervals[i][1];
//			若重叠则右边界变为两箭较小的右边界
			} else {
				count++;
			}

		}
		return count;
	}
}