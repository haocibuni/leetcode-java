import java.util.LinkedList;
import java.util.Queue;

//DFS法 时间复杂度mn
//在进行深度优先遍历时，通过visited避免遍历已经遍历的节点
//求数字各位时先取余再除，0不能取余
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
			// 取余数
			sum = sum + i % 10;

			i /= 10;
		}
		while (j > 0) {
			// 取余数
			sum = sum + j % 10;

			j /= 10;
		}
		return sum;

	}
}

//DFS法 时间复杂度mn
//在0-100 数位和前后两数满足(x + 1) % 10 != 0 ? s_x + 1 : s_x - 8; 若为整十数则减8，若不为则加1 通过该法不用多次循环计算数位和
//矩阵中 满足数位和的解 构成的几何形状形如多个 等腰直角三角形  所以不需要往左以及往上的判断条件和递归函数
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

//BFS法 时间复杂度mn
//Queue<String> queue = new LinkedList<String>(); queue是一种特殊的线性表
//队列为空遍历结束
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
