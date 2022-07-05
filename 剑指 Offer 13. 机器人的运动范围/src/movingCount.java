import java.util.LinkedList;
import java.util.Queue;

//DFS�� ʱ�临�Ӷ�mn
//�ڽ���������ȱ���ʱ��ͨ��visited��������Ѿ������Ľڵ�
//�����ָ�λʱ��ȡ���ٳ���0����ȡ��
class Solution_DFS {
	boolean[][] visited;

	public int movingCount(int m, int n, int k) {
		this.visited = new boolean[m][n];
		int sum = 0;

		sum = search(0, 0, m, n, k);

		return sum;

	}

	private int search(int i, int j, int m, int n, int k) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= m || j < 0 || j >= n || sum(i, j) > k || visited[i][j]) {
			return 0;
		} else {
			visited[i][j] = true;
			return 1 + search(i + 1, j, m, n, k) + search(i - 1, j, m, n, k) + search(i, j + 1, m, n, k)
					+ search(i, j - 1, m, n, k);
		}

	}

	public int sum(int i, int j) {
		int sum = 0;
		while (i > 0) {
			// ȡ����
			sum = sum + i % 10;

			i /= 10;
		}
		while (j > 0) {
			// ȡ����
			sum = sum + j % 10;

			j /= 10;
		}
		return sum;

	}
}

//DFS�� ʱ�临�Ӷ�mn
//��0-100 ��λ��ǰ����������(x + 1) % 10 != 0 ? s_x + 1 : s_x - 8; ��Ϊ��ʮ�����8������Ϊ���1 ͨ���÷����ö��ѭ��������λ��
//������ ������λ�͵Ľ� ���ɵļ�����״������ ����ֱ��������  ���Բ���Ҫ�����Լ����ϵ��ж������͵ݹ麯��
class Solution_DFS_TOWDIRECT {
	int m, n, k;
	boolean[][] visited;

	public int movingCount(int m, int n, int k) {
		this.m = m;
		this.n = n;
		this.k = k;
		this.visited = new boolean[m][n];
		return dfs(0, 0, 0, 0);
	}

	public int dfs(int i, int j, int si, int sj) {
		if (i >= m || j >= n || k < si + sj || visited[i][j])
			return 0;
		visited[i][j] = true;
		return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj)
				+ dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
	}
}

//BFS�� ʱ�临�Ӷ�mn
//Queue<String> queue = new LinkedList<String>(); queue��һ����������Ա�
//����Ϊ�ձ�������
class Solution_BFS {
	public int movingCount(int m, int n, int k) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int sum = 0;
		boolean[][] visited = new boolean[m][n];
		queue.add(new int[] { 0, 0, 0, 0 });
		while (queue.size() > 0) {
			int[] x = queue.poll();
			int i = x[0], j = x[1], si = x[2], sj = x[3];
			if (i >= m || j >= n || si + sj > k || visited[i][j]) {
				continue;
			}
			visited[i][j] = true;
			sum = sum + 1;
			queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
			queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });

		}
		return sum;

	}
}
