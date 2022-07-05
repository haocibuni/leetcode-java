import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//深度遍历法 
class Solution {
	boolean flag = false;

	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if (B == null) {
			return false;

		}
		DFS(A, B);
		return flag;

	}

	public void DFS(TreeNode A, TreeNode B) {
		if (A == null) {
			return;
		}
		flag = flag && subDFS(A, B);
		DFS(A.left, B);

		DFS(A.right, B);

	}

	public boolean subDFS(TreeNode A, TreeNode B) {
		if (B == null) {
			return true;
		}
		if (A == null || A.val != B.val)
			return false;

		return subDFS(A.left, B.left) && subDFS(A.right, B.right);

	}
}