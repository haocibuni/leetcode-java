import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//��ȱ����� ʱ�临�Ӷ�n*m
//�ȶ�A���б�����Ȼ���ж�A���Ӵ���B�Ƿ�ƥ��
//��Ҫע�����ĽṹҲӰ��ƥ��
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
