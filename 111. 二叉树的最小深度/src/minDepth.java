import javax.swing.tree.TreeNode;

class Solution {
	/**
	 * �ݹ鷨�������MaxDepthҪ���ӵ� ��Ϊ��С����ǴӸ��ڵ㵽���**Ҷ�ӽڵ�**�����·���ϵĽڵ�����
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);
		if (root.left == null) {
			return rightDepth + 1;
		}
		if (root.right == null) {
			return leftDepth + 1;
		}
		// ���ҽ�㶼��Ϊnull
		return Math.min(leftDepth, rightDepth) + 1;
	}
}