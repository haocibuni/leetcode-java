class Solution {
	/* �ݹ鷨�����������root�ڵ�ĸ߶� */
	public int maxDepth(Node root) {
		if (root == null)
			return 0;

		int depth = 0;
		if (root.children != null) {
			for (Node child : root.children) {
				depth = Math.max(depth, maxDepth(child));
			}
		}

		return depth + 1; // �нڵ�
	}
}