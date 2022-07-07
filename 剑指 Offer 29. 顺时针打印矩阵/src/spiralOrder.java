//ģ��߽編 ʱ�临�Ӷ�mn �ռ临�Ӷ�1
//ͨ�������������ұ߽��������й��ɵı���
//��������Ϊ�������ң��������£��������󣬴�������
class Solution {
	public int[] spiralOrder(int[][] matrix) {
		if ((matrix == null || matrix.length == 0) || (matrix.length == 1 && matrix[0] == null)) {
			int[] t = new int[0];
			return t;
		}
		int top = matrix.length - 1;
		int right = matrix[0].length - 1;
		int down = 0;
		int left = 0;
		int[] res = new int[matrix.length * matrix[0].length];

		int k = 0;
//		������while������ֹ���� ��Ҫÿ�α���������Խ�������ж�
		while (true) {

			for (int i = left; i <= right; i++) {
				res[k++] = matrix[down][i];
			}
			down = down + 1;
			if (down > top) {
				break;
			}
			for (int i = down; i <= top; i++) {
				res[k++] = matrix[i][right];
			}
			right = right - 1;
			if (right < left) {
				break;
			}
			for (int i = right; i >= left; i--) {
				res[k++] = matrix[top][i];
			}
			top = top - 1;
			if (down > top) {
				break;
			}
			for (int i = top; i >= down; i--) {
				res[k++] = matrix[i][left];
			}
			left = left + 1;
			if (right < left) {
				break;
			}

		}
		return res;

	}
}