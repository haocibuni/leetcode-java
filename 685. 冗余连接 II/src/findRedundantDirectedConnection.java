// 根据示例, 最起码有 2 种情况是不允许的:
// 1. 某一点入度大于 1
// 2. 形成了环
class Solution {
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int n = edges.length;
		// indegrees[i] 表示 入 为第i个节点的 edge 在 edges 中的索引
		Integer[] indegrees = new Integer[n + 1];
		for (int i = 0; i < n; i++) {
			int[] e = edges[i];
			if (indegrees[e[1]] == null)
				indegrees[e[1]] = i;
			else {
				// 不为 null, 说明e[1] 的入度为 2
				// 2 条边索引分别是 indegrees[e[1]] 和 i
				// 从后往前判断, 将其删除能否构成树(1 个连通分量)
				DSU dsu = new DSU(n + 1);
				dsu.union(0, 1);
				for (int j = 0; j < n; j++) {
					if (j == i)
						continue;
					dsu.union(edges[j][0], edges[j][1]);
				}
				return dsu.n == 1 ? e : edges[indegrees[e[1]]];
			}
		}
		// 有环的情况, 如果连接 2 点之前就已经连通了, 说明当前边就是最后那个多余的
		DSU dsu1 = new DSU(n + 1);
		dsu1.union(0, 1);
		for (int i = 0; i < n; i++) {
			int[] e = edges[i];
			if (dsu1.isConnected(e[0], e[1]))
				return e;
			dsu1.union(e[0], e[1]);
		}
		return new int[2];
	}
}

class DSU {
	private int[] parents;
	private int[] size;
	// 连通分量的个数
	public int n;

	DSU(int n) {
		this.n = n;
		size = new int[n];
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
			size[i] = 1;
		}
	}

	public int find(int x) {
		if (parents[x] != x) {
			parents[x] = find(parents[x]);
		}
		return parents[x];
	}

	public boolean union(int x, int y) {
		int u = find(x), v = find(y);
		if (u == v)
			return false;
		parents[u] = v;
		size[v] += size[u];
		n--;
		return true;
	}

	public boolean isConnected(int x, int y) {
		return find(x) == find(y);
	}

	public int getSize(int x) {
		return size[find(x)];
	}
}