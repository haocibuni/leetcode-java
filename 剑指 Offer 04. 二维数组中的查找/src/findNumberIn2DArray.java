//����ͨ����������Ѱ��Ŀ������ȴ�����ˣ�������֮��ʱ��Ӧ���к��п��ܻ���ڱȵ�һ����С����
class Solution_bias {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if ((matrix == null || matrix.length == 0) || (matrix.length == 1 && matrix[0].length == 0)) {
			return false;
		}
		int n = matrix.length;
		int m = matrix[0].length;

		if (n == m) {
			for (int i = 0; i < n - 1; i++) {
				if (target == matrix[i][i]) {
					return true;
				} else if (target > matrix[i][i] && target < matrix[i + 1][i + 1]) {
					for (int j = 0; j < i + 1; j++) {
						if (matrix[j][i + 1] == target || matrix[i + 1][j] == target) {
							return true;
						}
					}
				}

			}
			if (target == matrix[n - 1][n - 1]) {
				return true;
			} else {
				return false;
			}
		}
		if (n > m) {
			for (int i = 0; i < m - 1; i++) {
				if (target == matrix[i][i]) {
					return true;
				} else if (target > matrix[i][i] && target < matrix[i + 1][i + 1]) {
					for (int j = 0; j < i + 1; j++) {
						if (matrix[j][i + 1] == target || matrix[i + 1][j] == target) {
							return true;
						}
					}
				}

			}
			for (int j = m - 1; j < n - 1; j++) {
				if (target == matrix[j][m - 1]) {
					return true;
				} else if (target > matrix[j][m - 1] && target < matrix[j + 1][m - 1]) {
					for (int k = 0; k < m - 1; k++) {
						if (matrix[j][k] == target) {
							return true;
						}
					}
				}

			}
			if (target == matrix[n - 1][m - 1]) {
				return true;
			} else {
				return false;
			}

		}
		if (n < m) {
			for (int i = 0; i < n - 1; i++) {
				if (target == matrix[i][i]) {
					return true;
				} else if (target > matrix[i][i] && target < matrix[i + 1][i + 1]) {
					for (int j = 0; j < i + 1; j++) {
						if (matrix[j][i + 1] == target || matrix[i + 1][j] == target) {
							return true;
						}
					}
				}

			}
			for (int j = n - 1; j < m - 1; j++) {
				if (target == matrix[n - 1][j]) {
					return true;
				} else if (target > matrix[n - 1][j] && target < matrix[n - 1][j + 1]) {
					for (int k = 0; k < n - 1; k++) {
						if (matrix[k][j] == target) {
							return true;
						}
					}
				}

			}
			if (target == matrix[n - 1][m - 1]) {
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
}

//����ö�ٷ� ��Ҫ�ж���ά�����Ƿ�Ϊ�գ��������matrix.length == 0 ��  matrix.length == 1 && matrix[0].length == 0
class Solution_force {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if ((matrix == null || matrix.length == 0) || (matrix.length == 1 && matrix[0].length == 0)) {
			return false;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (target == matrix[i][j]) {
					return true;
				}
			}
		}
		return false;

	}
}

//���󣬶�����������1 �����Ͻǿ�ʼ����  �����䲻��
class Solution_binary_search_tree1 {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if ((matrix == null || matrix.length == 0) || (matrix.length == 1 && matrix[0].length == 0)) {
			return false;
		}
		int n = matrix.length;
		int m = matrix[0].length;
		int i = 0, j = 0;
		while (i < n && j < m) {
			if (matrix[i][j] == target) {
				return true;
			}
			boolean flag1, flag2;
			if (i == n - 1) {
				j++;
				continue;
			}
			if (j == m - 1) {
				i++;
				continue;
			}
			flag1 = (matrix[i][j + 1] <= target && target < matrix[i + 1][j])
					|| (matrix[i + 1][j] <= target && target < matrix[i][j + 1]) ? true : false;
			flag2 = matrix[i][j + 1] < matrix[i + 1][j] ? true : false;
			if (flag1 == true) {
				if (flag2 == true) {
					j++;
				} else {
					i++;
				}

			} else {
				if (flag2 == true) {
					i++;
				} else {
					j++;
				}
			}

		}
		return false;

	}
}

//������������ �����Ͻǿ�ʼ������i��j�ֱ�Ϊ�к��У�����ά����Ϊ����matrix[0]�����ڻᱨ��
class Solution_binary_search_tree2 {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if ((matrix == null || matrix.length == 0) || (matrix.length == 1 && matrix[0].length == 0)) {
			return false;
		}
		int i = 0, j = matrix[0].length - 1;
		while (j >= 0 && i < matrix.length) {
			if (target == matrix[i][j]) {
				return true;
			} else if (target < matrix[i][j]) {
				j--;
			} else {
				i++;
			}
		}
		return false;

	}
}

//������������ �����½ǿ�ʼ������i��j�ֱ�Ϊ�к��У�����ά����Ϊ����iΪ-1��������while����ֱ��return false
class Solution_binary_search_tree3 {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		int i = matrix.length - 1, j = 0;
		while (i >= 0 && j < matrix[0].length) {
			if (matrix[i][j] > target)
				i--;
			else if (matrix[i][j] < target)
				j++;
			else
				return true;
		}
		return false;
	}
}
