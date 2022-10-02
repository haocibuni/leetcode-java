import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//回溯法
class Solution {
//	二维字符串结果数组
	List<List<String>> result = new ArrayList<>();
//	二位棋盘数组
	char[][] chessboard;

	public List<List<String>> solveNQueens(int n) {
//		根据n创建棋盘数组
		char[][] chessboard = new char[n][n];
//		向棋盘数组中填充.
		for (char[] c : chessboard) {
			Arrays.fill(c, '.');
		}
//		按行来进行递归
		backTracking(n, 0, chessboard);
//		返回结果数组
		return result;
	}

	public void backTracking(int n, int row, char[][] chessboard) {
//		如果行数等于n，则向结果数组中添加一维字符串数组
		if (n == row) {
			result.add(Array2List(chessboard));
			return;

		}
//		遍历改行的每一列
		for (int i = 0; i < n; i++) {
//			若每一列的元素都合适则将其更改为q
			if (isValid(row, i, n, chessboard)) {
				chessboard[row][i] = 'Q';
//				递归下一行
				backTracking(n, row + 1, chessboard);
//				回溯
				chessboard[row][i] = '.';
			}
		}
	}

	public List Array2List(char[][] chessboard) {
//		将二维字符串数组转化为一维列表
		List<String> list = new ArrayList<>();
		for (char[] c : chessboard) {
			list.add(String.copyValueOf(c));
		}
		return list;
	}

	public boolean isValid(int row, int col, int n, char[][] chessboard) {
		// 检查列，该列前面是否有王
		for (int i = 0; i < row; ++i) { // 相当于剪枝
			if (chessboard[i][col] == 'Q') {
				return false;
			}
		}

		// 检查45度对角线 i-- j--
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chessboard[i][j] == 'Q') {
				return false;
			}
		}

		// 检查135度对角线 i-- j++
		for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
			if (chessboard[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}
}