import java.util.Arrays;

class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
//		�������һ��
		int count = 0;
		int leftEdge = Integer.MIN_VALUE;
//		������Χ
		for (int i = 0; i < intervals.length; i++) {
//			����ǰ����ļ���߽����һ�����ұ߽粻�ص�������Ҫ����һ��
			if (leftEdge <= intervals[i][0]) {
				leftEdge = intervals[i][1];
//			���ص����ұ߽��Ϊ������С���ұ߽�
			} else {
				count++;
			}

		}
		return count;
	}
}