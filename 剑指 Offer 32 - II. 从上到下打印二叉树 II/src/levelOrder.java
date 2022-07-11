import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//��α����� ʱ�临�Ӷ�Ϊn �ռ临�Ӷ�Ϊn
//�����ж��Ƿ�Ϊ����
//ͨ������ʵ�ֲ�α�����ÿ�����Ϊһ��Ԫ�ض�����һ��Ԫ�أ�
//�����в�Ϊ��ʱ��������������нڵ㣬������һ��ڵ�ȫ�����룬��ʱÿ�������Ϊһ��ڵ�
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
//			ÿ���������Ҫ��ʱlist
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = queue.size(); i > 0; i--) {
//				ÿ��ѭ������Ҫ��ʱtreenode
				TreeNode tempNode = queue.poll();
				temp.add(tempNode.val);
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
			}
			res.add(temp);
		}
		return res;

	}
}