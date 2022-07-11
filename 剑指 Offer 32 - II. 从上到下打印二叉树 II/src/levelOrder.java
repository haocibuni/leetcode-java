import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//层次遍历法 时间复杂度为n 空间复杂度为n
//首先判断是否为空树
//通过队列实现层次遍历，每次输出为一行元素而不是一个元素，
//当队列不为空时，输出队列里所有节点，并将下一层节点全部输入，这时每次输出的为一层节点
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
//			每次输出都需要临时list
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = queue.size(); i > 0; i--) {
//				每次循环都需要临时treenode
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