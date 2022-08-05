//תȦ�� ʱ�临�Ӷ�n2
//ȷ��Ȧ�����м���ֵ �Լ�ÿȦ�������ĳ��ȱ仯
class Solution {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int x = 0, y = 0;
		int loop = n / 2;
		int mid = n / 2;
		int i, j;
		int count = 1;
		int offset = 1;
		while (loop > 0) {
			i = x;
			j = y;
			for (j = y; j < n - offset; j++) {
				res[i][j] = count;
				count++;
			}
			for (i = x; i < n - offset; i++) {
				res[i][j] = count;
				count++;
			}
			for (; j > y; j--) {
				res[i][j] = count;
				count++;
			}
			for (; i > x; i--) {
				res[i][j] = count;
				count++;
			}
			x++;
			y++;
			loop--;
			offset++;
		}
		if (n % 2 != 0) {
			res[mid][mid] = n * n;
		}
		return res;
	}
}