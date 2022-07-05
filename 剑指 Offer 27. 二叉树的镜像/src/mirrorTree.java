import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//广度优先搜索 从上往下交换 时间复杂度n 空间复杂度n
//注意需判断根节点是否为空 代码判断条件分别为栈是否为空，左右节点是否为空，并没有根节点为空
class Solution_BFS {
	public TreeNode mirrorTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode tree = queue.poll();
			TreeNode tempNode = new TreeNode();
			tempNode = tree.left;
			tree.left = tree.right;
			tree.left = tempNode;
			if (tree.left != null)
				queue.offer(tree.left);
			if (tree.right != null)
				queue.offer(tree.right);

		}
		return root;

	}
}

//深度优先搜索 从下往上交换 时间复杂度n 空间复杂度n
class Solution_DFS {
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode tmp = root.left;
		root.left = mirrorTree(root.right);
		root.right = mirrorTree(tmp);
		return root;
	}
}
