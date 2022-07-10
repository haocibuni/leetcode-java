import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//广度优先搜索 时间复杂度为n 空间复杂度为n
//Queue 需要 new LinkedList 可变数组为ArrayList
//对于队列尽量用offer而不用add 尽量用poll而不用remove
class Solution {
	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		queue.add(root);

		while (!queue.isEmpty()) {
//			此处不需要new新的节点 只需要一个地址即可
			TreeNode treeNode = queue.poll();
			ans.add(treeNode.val);
			if (treeNode.left != null) {
				queue.add(treeNode.left);
			}
			if (treeNode.right != null) {
				queue.add(treeNode.right);
			}
		}
//		将ArrayList转化为int
		int[] res = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			res[i] = ans.get(i);
		return res;

	}
}