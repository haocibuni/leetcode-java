// ����ʾ��, �������� 2 ������ǲ������:
// 1. ĳһ����ȴ��� 1
// 2. �γ��˻�
class Solution {
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int n = edges.length;
		// indegrees[i] ��ʾ �� Ϊ��i���ڵ�� edge �� edges �е�����
		Integer[] indegrees = new Integer[n + 1];
		for (int i = 0; i < n; i++) {
			int[] e = edges[i];
			if (indegrees[e[1]] == null)
				indegrees[e[1]] = i;
			else {
				// ��Ϊ null, ˵��e[1] �����Ϊ 2
				// 2 ���������ֱ��� indegrees[e[1]] �� i
				// �Ӻ���ǰ�ж�, ����ɾ���ܷ񹹳���(1 ����ͨ����)
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
		// �л������, ������� 2 ��֮ǰ���Ѿ���ͨ��, ˵����ǰ�߾�������Ǹ������
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
	// ��ͨ�����ĸ���
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