import java.util.Arrays;

class Solution {
	public int findMinArrowShots(int[][] points) {
//		�Զ�ά�������鰴�±�0�������С��������
		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
//		�������һ��
		int count = 1;
//		������Χ
		for (int i = 1; i < points.length; i++) {
//			����ǰ����ļ���߽����һ�����ұ߽粻�ص�������Ҫ����һ��
			if (points[i][0] > points[i - 1][1]) {
				count++;
//			���ص����ұ߽��Ϊ������С���ұ߽�
			} else {
				points[i][1] = Math.min(points[i][1], points[i - 1][1]);
			}

		}
		return count;

	}
}