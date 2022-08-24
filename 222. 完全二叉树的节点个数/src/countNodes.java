import javax.swing.tree.TreeNode;

class Solution {
	/**
	 * 针对完全二叉树的解法
	 *
	 * 满二叉树的结点数为：2^depth - 1
	 */
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		if (leftDepth == rightDepth) {// 左子树是满二叉树
			// 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
//			(int)Math.pow(2, left) 的高端写法 左子树加根节点 加右子树递归
			return (1 << leftDepth) + countNodes(root.right);
		} else {// 右子树是满二叉树
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