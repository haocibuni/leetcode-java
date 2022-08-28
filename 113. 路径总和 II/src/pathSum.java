import java.util.LinkedList;

import javax.swing.tree.TreeNode;

class Solution {
	List<List<Integer>> result;
	LinkedList<Integer> path;

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		result = new LinkedList<>();
		path = new LinkedList<>();
		travesal(root, targetSum);
		return result;
	}

	private void travesal(TreeNode root, int count) {
		if (root == null)
			return;
		path.offer(root.val);
		count -= root.val;
		if (root.left == null && root.right == null && count == 0) {
			result.add(new LinkedList<>(path));
		}
		travesal(root.left, count);
		travesal(root.right, count);
		path.removeLast(); // »ØËÝ
	}
}