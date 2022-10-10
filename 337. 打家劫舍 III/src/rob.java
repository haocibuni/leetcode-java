
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	public int rob(TreeNode root) {
		int[] res = robhelp(root);
		return Math.max(res[0], res[1]);
	}

//  �������
	public int[] robhelp(TreeNode root) {
		int[] res = new int[2];
//		����ǰ�ڵ�Ϊ�գ���͵�벻͵��Ϊ0
		if (root == null) {
			return res;
		}
//		��ڵ�͵�벻͵�Ľ��
		int[] left = robhelp(root.left);
//		�ҽڵ�͵�벻͵�Ľ��
		int[] right = robhelp(root.right);
//		��͵��ǰ�ڵ㣬��ѡȡ���ҽڵ�����ֵ
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
//		͵��ǰ�ڵ�
		res[1] = left[0] + right[0] + root.val;
		return res;
	}
}