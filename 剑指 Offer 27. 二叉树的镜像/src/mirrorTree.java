import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//����������� �������½��� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//ע�����жϸ��ڵ��Ƿ�Ϊ�� �����ж������ֱ�Ϊջ�Ƿ�Ϊ�գ����ҽڵ��Ƿ�Ϊ�գ���û�и��ڵ�Ϊ��
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

//����������� �������Ͻ��� ʱ�临�Ӷ�n �ռ临�Ӷ�n
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
