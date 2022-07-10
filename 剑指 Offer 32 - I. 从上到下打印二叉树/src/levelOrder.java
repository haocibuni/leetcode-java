import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//����������� ʱ�临�Ӷ�Ϊn �ռ临�Ӷ�Ϊn
//Queue ��Ҫ new LinkedList �ɱ�����ΪArrayList
//���ڶ��о�����offer������add ������poll������remove
class Solution {
	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		queue.add(root);

		while (!queue.isEmpty()) {
//			�˴�����Ҫnew�µĽڵ� ֻ��Ҫһ����ַ����
			TreeNode treeNode = queue.poll();
			ans.add(treeNode.val);
			if (treeNode.left != null) {
				queue.add(treeNode.left);
			}
			if (treeNode.right != null) {
				queue.add(treeNode.right);
			}
		}
//		��ArrayListת��Ϊint
		int[] res = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			res[i] = ans.get(i);
		return res;

	}
}