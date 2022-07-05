import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//深度遍历法 时间复杂度n*m
//先对A进行遍历，然后判断A的子串和B是否匹配
//需要注意树的结构也影响匹配
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

class Solution {
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
	}

	boolean recur(TreeNode A, TreeNode B) {
		if (B == null)
			return true;
		if (A == null || A.val != B.val)
			return false;
		return recur(A.left, B.left) && recur(A.right, B.right);
	}
}
