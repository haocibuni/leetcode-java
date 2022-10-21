class Solution {
	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		int[] parent = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
		}
		int node1 = 0, node2 = 0;
		for (int i = 0; i < edges.length; i++) {
			node1 = edges[i][0];
			node2 = edges[i][1];
			if (find(parent, node1) == find(parent, node2)) {
				break;
			} else {
				union(parent, node1, node2);
			}
		}
		return new int[] { node1, node2 };
	}

	public void union(int[] parent, int index1, int index2) {
		parent[find(parent, index2)] = find(parent, index1);
	}

	public int find(int[] parent, int index) {
		while (index != parent[index]) {
			parent[index] = find(parent, parent[index]);
			index = find(parent, parent[index]);
		}
		return parent[index];
	}
}