class Solution {
	/* 递归法，后序遍历求root节点的高度 */
	public int maxDepth(Node root) {
		if (root == null)
			return 0;

		int depth = 0;
		if (root.children != null) {
			for (Node child : root.children) {
				depth = Math.max(depth, maxDepth(child));
			}
		}

		return depth + 1; // 中节点
	}
}