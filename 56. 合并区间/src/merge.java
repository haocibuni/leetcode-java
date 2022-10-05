import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public int[][] merge(int[][] intervals) {

//		һά������������
		List<int[]> result = new LinkedList<>();
//		����ʼ���ִ�С��������
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//		������߽�
		int left = intervals[0][0];
//		�����ұ߽�
		int right = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
//			����ǰ����߽�����ұ߽�
			if (intervals[i][0] > right) {
//				�������һ������
				result.add(new int[] { left, right });
//				������ǰ����߽���ұ߽縳ֵ
				left = intervals[i][0];
				right = intervals[i][1];
//			�����ڽ�������ȡ�����ұ߽�
			} else {
				right = Math.max(right, intervals[i][1]);
			}
		}
//		������������һ������
		result.add(new int[] { left, right });
		return result.toArray(new int[result.size()][]);

	}
}