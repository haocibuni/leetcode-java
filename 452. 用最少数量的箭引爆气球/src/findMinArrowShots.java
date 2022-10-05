import java.util.Arrays;

class Solution {
	public int findMinArrowShots(int[][] points) {
//		对二维整型数组按下标0的数组从小到大排序
		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
//		至少射出一箭
		int count = 1;
//		遍历范围
		for (int i = 1; i < points.length; i++) {
//			若当前射出的箭左边界跟上一箭的右边界不重叠，则需要再射一箭
			if (points[i][0] > points[i - 1][1]) {
				count++;
//			若重叠则右边界变为两箭较小的右边界
			} else {
				points[i][1] = Math.min(points[i][1], points[i - 1][1]);
			}

		}
		return count;

	}
}