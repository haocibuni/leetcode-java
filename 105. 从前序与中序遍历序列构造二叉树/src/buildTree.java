import java.util.HashMap;

import javax.swing.tree.TreeNode;

class Solution {
	Map<Integer, Integer> map;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) { // ��map�����������е���ֵ��Ӧλ��
			map.put(inorder[i], i);
		}

		return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length); // ǰ�պ�
	}

	public TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
		// ������ķ�Χ����ǰ�պ�
		if (preBegin >= preEnd || inBegin >= inEnd) { // ����������ҿ���˵��û��Ԫ�أ����ؿ���
			return null;
		}
		int rootIndex = map.get(preorder[preBegin]); // �ҵ�ǰ������ĵ�һ��Ԫ������������е�λ��
		TreeNode root = new TreeNode(inorder[rootIndex]); // ������
		int lenOfLeft = rootIndex - inBegin; // ������������������������ȷ��ǰ�����еĸ���
		root.left = findNode(preorder, preBegin + 1, preBegin + lenOfLeft + 1, inorder, inBegin, rootIndex);
		root.right = findNode(preorder, preBegin + lenOfLeft + 1, preEnd, inorder, rootIndex + 1, inEnd);

		return root;
	}
}