import javax.swing.tree.TreeNode;

class Solution {
	/**
	 * �����ȫ�������Ľⷨ
	 *
	 * ���������Ľ����Ϊ��2^depth - 1
	 */
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		if (leftDepth == rightDepth) {// ����������������
			// 2^leftDepth��ʵ�� ��2^leftDepth - 1�� + 1 �������� + �����
//			(int)Math.pow(2, left) �ĸ߶�д�� �������Ӹ��ڵ� ���������ݹ�
			return (1 << leftDepth) + countNodes(root.right);
		} else {// ����������������
			return (1 << rightDepth) + countNodes(root.left);
		}
	}

	private int getDepth(TreeNode root) {
		int depth = 0;
		while (root != null) {
			root = root.left;
			depth++;
		}
		return depth;
	}
}