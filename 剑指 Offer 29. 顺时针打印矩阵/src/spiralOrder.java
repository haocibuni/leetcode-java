
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

		int i = 0, j = 0, k = 0;
		while (true) {

			while (j <= right) {
				res[k++] = matrix[i][j++];

			}
			j--;
			down = down + 1;
			if (down > top) {
				break;

			}
			while (i <= top) {
				res[k++] = matrix[i++][j];

			}
			i--;
			right = right - 1;
			if (right > left) {
				break;

			}
			while (j >= left) {
				res[k++] = matrix[i][j--];
			}
			j++;
			top = top - 1;
			if (down > top) {
				break;

			}
			while (i >= down) {
				res[k++] = matrix[i--][j];
			}
			i++;
			left = left + 1;
			if (right > left) {
				break;

			}

		}
		return res;

	}
}