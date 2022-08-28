import java.util.HashMap;

import javax.swing.tree.TreeNode;

class Solution {
	Map<Integer, Integer> map; // ���������ֵ����λ��

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) { // ��map�����������е���ֵ��Ӧλ��
			map.put(inorder[i], i);
		}

		return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length); // ǰ�պ�
	}

	public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
		// ������ķ�Χ����ǰ�պ�
		if (inBegin >= inEnd || postBegin >= postEnd) { // ����������ҿ���˵��û��Ԫ�أ����ؿ���
			return null;
		}
		int rootIndex = map.get(postorder[postEnd - 1]); // �ҵ�������������һ��Ԫ������������е�λ��
		TreeNode root = new TreeNode(inorder[rootIndex]); // ������
		int lenOfLeft = rootIndex - inBegin; // ������������������������ȷ���������еĸ���
		root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
		root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);

		return root;
	}
}