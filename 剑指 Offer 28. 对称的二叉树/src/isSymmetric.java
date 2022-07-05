import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//递归法 时间复杂度为n
class Solution_recur {
	public boolean isSymmetric(TreeNode root) {
		return root == null ? true : recur(root.left, root.right);
	}

	boolean recur(TreeNode L, TreeNode R) {
//    	成功终止条件：左右两支在前面的值都相等且同时达到非叶子节点
		if (L == null && R == null)
			return true;
//      失败终止条件：左右两只不同时达到非叶子节或者左右两支的值不相等
		if (L == null || R == null || L.val != R.val)
			return false;
		return recur(L.left, R.right) && recur(L.right, R.left);
	}
}