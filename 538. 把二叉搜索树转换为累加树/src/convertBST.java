import javax.swing.tree.TreeNode;

class Solution {
	int sum;

	public TreeNode convertBST(TreeNode root) {
		sum = 0;
		convertBST1(root);
		return root;
	}

	// ��������˳��������ۼӼ���
	public void convertBST1(TreeNode root) {
		if (root == null) {
			return;
		}
		convertBST1(root.right);
		sum += root.val;
		root.val = sum;
		convertBST1(root.left);
	}
}