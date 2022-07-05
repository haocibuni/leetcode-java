//DFS�Ӽ�֦ ʱ�临�Ӷ�ʱ�临�Ӷ�mn*l3
//�ݹ�DFS ���жϵ�ǰ�ڵ��Ƿ�ʧ�� ����ʧ�����ж��Ƿ�ﵽword�ĳ���
//��Ҫ���Ѿ������Ľڵ㸳ֵΪ�� ����������Ѿ������Ľڵ� ��AB != ABA�� 
//���board��ԭ ������һ������
class Solution_recur {
	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board.length == 1 && board[0].length == 0) {
			return false;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (search(board, word, i, j, 1)) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean search(char[][] board, String word, int i, int j, int k) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k - 1)) {
			return false;
		}
		if (k == word.length()) {
			return true;
		}
		board[i][j] = '\0';
		boolean flag = false;
		if (search(board, word, i + 1, j, k + 1) || search(board, word, i - 1, j, k + 1)
				|| search(board, word, i, j + 1, k + 1) || search(board, word, i, j - 1, k + 1)) {
			flag = true;
		}
		board[i][j] = word.charAt(k - 1);
		return flag;
	}
}

//�����жϷ� ʱ�临�Ӷ�mn*l3 ����
class Solution_if {
	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board.length == 1 && board[0].length == 0) {
			return false;
		}
		if (word.length() > board.length * board[0].length) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j]) {
					if (flag == true) {
						break;
					}
					flag = search(board, word, i, j);

				}

			}
		}
		return flag;

	}

	public boolean search(char[][] board, String word, int fi, int fj) {
		boolean flag = true;
		for (int i = 1; i < word.length(); i++) {
			if (fi == 0 && fj == 0) {
				if (board[fi + 1][fj] == word.charAt(i)) {
					fi = fi + 1;
					continue;
				} else if (board[fi][fj + 1] == word.charAt(i)) {
					fj = fj + 1;
					continue;
				} else {
					flag = false;
					break;
				}
			} else if (fi == board.length - 1 && fj == 0) {
				if (board[fi - 1][fj] == word.charAt(i)) {
					fi = fi - 1;
					continue;
				} else if (board[fi][fj + 1] == word.charAt(i)) {
					fj = fj + 1;
					continue;
				} else {
					flag = false;
					break;
				}
			} else if (fi == 0 && fj == board[0].length - 1) {
				if (board[fi + 1][fj] == word.charAt(i)) {
					fi = fi + 1;
					continue;
				} else if (board[fi][fj - 1] == word.charAt(i)) {
					fj = fj - 1;
					continue;
				} else {
					flag = false;
					break;
				}
			} else if (fi == board.length - 1 && fj == board[0].length - 1) {
				if (board[fi - 1][fj] == word.charAt(i)) {
					fi = fi - 1;
					continue;
				} else if (board[fi][fj - 1] == word.charAt(i)) {
					fj = fj - 1;
					continue;
				} else {
					flag = false;
					break;
				}
			} else if (fi == 0 && (fj != 0 && fj != board[0].length - 1)) {
				if (board[fi + 1][fj] == word.charAt(i)) {
					fi = fi + 1;
					continue;
				} else if (board[fi][fj - 1] == word.charAt(i)) {
					fj = fj - 1;
					continue;
				} else if (board[fi][fj + 1] == word.charAt(i)) {
					fj = fj + 1;
					continue;
				} else {
					flag = false;
					break;
				}

			} else if (fi == board.length - 1 && (fj != 0 && fj != board[0].length - 1)) {
				if (board[fi - 1][fj] == word.charAt(i)) {
					fi = fi - 1;
					continue;
				} else if (board[fi][fj - 1] == word.charAt(i)) {
					fj = fj - 1;
					continue;
				} else if (board[fi][fj + 1] == word.charAt(i)) {
					fj = fj + 1;
					continue;
				} else {
					flag = false;
					break;
				}

			} else if (fj == 0 && (fi != 0 && fi != board.length - 1)) {
				if (board[fi][fj + 1] == word.charAt(i)) {
					fj = fj + 1;
					continue;
				} else if (board[fi - 1][fj] == word.charAt(i)) {
					fi = fi - 1;
					continue;
				} else if (board[fi + 1][fj] == word.charAt(i)) {
					fi = fi + 1;
					continue;
				} else {
					flag = false;
					break;
				}

			} else if (fj == board[0].length - 1 && (fi != 0 || fi != board.length - 1)) {
				if (board[fi][fj - 1] == word.charAt(i)) {
					fj = fj - 1;
					continue;
				} else if (board[fi - 1][fj] == word.charAt(i)) {
					fi = fi - 1;
					continue;
				} else if (board[fi + 1][fj] == word.charAt(i)) {
					fi = fi + 1;
					continue;
				} else {
					flag = false;
					break;
				}

			} else if ((fj != 0 && fj != board[0].length - 1) && (fi != 0 && fi != board.length - 1)) {
				if (board[fi - 1][fj] == word.charAt(i)) {
					fi = fi - 1;
					continue;
				} else if (board[fi + 1][fj] == word.charAt(i)) {
					fi = fi + 1;
					continue;
				} else if (board[fi][fj - 1] == word.charAt(i)) {
					fj = fj - 1;
					continue;
				} else if (board[fi][fj + 1] == word.charAt(i)) {
					fj = fj + 1;
					continue;
				} else {
					flag = false;
					break;
				}
			}

		}

		return flag;
	}

}
