import javax.swing.tree.TreeNode;

class Solution {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) // �����ǰ�ڵ�Ϊ�գ�Ҳ����ζ��val�ҵ��˺��ʵ�λ�ã���ʱ�����ڵ�ֱ�ӷ��ء�
			return new TreeNode(val);

		if (root.val < val) {
			root.right = insertIntoBST(root.right, val); // �ݹ鴴��������
		} else if (root.val > val) {
			root.left = insertIntoBST(root.left, val); // �ݹ鴴��������
		}
		return root;
	}
}