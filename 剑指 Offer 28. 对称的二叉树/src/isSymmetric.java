import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//�ݹ鷨 ʱ�临�Ӷ�Ϊn
class Solution_recur {
	public boolean isSymmetric(TreeNode root) {
		return root == null ? true : recur(root.left, root.right);
	}

	boolean recur(TreeNode L, TreeNode R) {
//    	�ɹ���ֹ������������֧��ǰ���ֵ�������ͬʱ�ﵽ��Ҷ�ӽڵ�
		if (L == null && R == null)
			return true;
//      ʧ����ֹ������������ֻ��ͬʱ�ﵽ��Ҷ�ӽڻ���������֧��ֵ�����
		if (L == null || R == null || L.val != R.val)
			return false;
		return recur(L.left, R.right) && recur(L.right, R.left);
	}
}