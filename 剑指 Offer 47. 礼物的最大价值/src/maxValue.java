//��̬�滮�� ʱ�临�Ӷ�mn �ռ临�Ӷ�1
//�ø�����grid����ԭ���޸�״̬
class Solution_dp {
	public int maxValue(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0) {
					continue;
				} else if (i == 0 && j != 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				} else if (j == 0 && i != 0) {
					grid[i][j] = grid[i][j] + grid[i - 1][j];
				} else {
					grid[i][j] = grid[i][j] + Math.max(grid[i][j - 1], grid[i - 1][j]);
				}
			}

		}
		return grid[n - 1][m - 1];
	}
}

//�Ե�һ��״̬���ԣ��ڶ�����״̬��ǰ��ʼ��
class Solution {
	public int maxValue(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		for (int i = 1; i < m; i++) {
			grid[0][i] = grid[0][i] + grid[0][i - 1];
		}
		for (int i = 1; i < n; i++) {
			grid[i][0] = grid[i][0] + grid[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				grid[i][j] = grid[i][j] + Math.max(grid[i][j - 1], grid[i - 1][j]);
			}

		}
		return grid[n - 1][m - 1];
	}
}