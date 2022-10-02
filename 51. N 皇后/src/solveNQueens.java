import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//���ݷ�
class Solution {
//	��ά�ַ����������
	List<List<String>> result = new ArrayList<>();
//	��λ��������
	char[][] chessboard;

	public List<List<String>> solveNQueens(int n) {
//		����n������������
		char[][] chessboard = new char[n][n];
//		���������������.
		for (char[] c : chessboard) {
			Arrays.fill(c, '.');
		}
//		���������еݹ�
		backTracking(n, 0, chessboard);
//		���ؽ������
		return result;
	}

	public void backTracking(int n, int row, char[][] chessboard) {
//		�����������n�����������������һά�ַ�������
		if (n == row) {
			result.add(Array2List(chessboard));
			return;

		}
//		�������е�ÿһ��
		for (int i = 0; i < n; i++) {
//			��ÿһ�е�Ԫ�ض������������Ϊq
			if (isValid(row, i, n, chessboard)) {
				chessboard[row][i] = 'Q';
//				�ݹ���һ��
				backTracking(n, row + 1, chessboard);
//				����
				chessboard[row][i] = '.';
			}
		}
	}

	public List Array2List(char[][] chessboard) {
//		����ά�ַ�������ת��Ϊһά�б�
		List<String> list = new ArrayList<>();
		for (char[] c : chessboard) {
			list.add(String.copyValueOf(c));
		}
		return list;
	}

	public boolean isValid(int row, int col, int n, char[][] chessboard) {
		// ����У�����ǰ���Ƿ�����
		for (int i = 0; i < row; ++i) { // �൱�ڼ�֦
			if (chessboard[i][col] == 'Q') {
				return false;
			}
		}

		// ���45�ȶԽ��� i-- j--
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chessboard[i][j] == 'Q') {
				return false;
			}
		}

		// ���135�ȶԽ��� i-- j++
		for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
			if (chessboard[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}
}