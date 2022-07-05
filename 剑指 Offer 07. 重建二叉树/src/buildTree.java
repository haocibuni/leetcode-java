import java.util.HashMap;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//���α���������ǰ�������Ϊ������ǰ�������������ǰ�����飬�����������Ϊ����������������������������飻���еݹ飬��������Ϊǰ���������������������ͬԪ��
//�ռ临�Ӷȸ� ʱ�临�Ӷ�Ϊn2
//class Solution:
//def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
//  if not preorder or not inorder:return None
//  root = TreeNode(preorder[0])
//  root.left = self.buildTree(preorder[1:inorder.index(preorder[0])+1], inorder[:inorder.index(preorder[0])])
//  root.right = self.buildTree(preorder[inorder.index(preorder[0])+1:], inorder[inorder.index(preorder[0])+1:])
//  return root
class Solution_divide_force {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < preorder.length; i++) {
			for (int j = 0; j < inorder.length; j++) {
				if (preorder[i] == inorder[j]) {
					int[] newleftpreorder = new int[j - i];
					int[] newleftinorder = new int[j - i];
					int[] newrightpreorder = new int[inorder.length - j - 1];
					int[] newrightinorder = new int[inorder.length - j - 1];
					System.arraycopy(preorder, i + 1, newleftpreorder, 0, j - i);
					System.arraycopy(inorder, 0, newleftinorder, 0, j - i);
					System.arraycopy(inorder, j + 1, newrightinorder, 0, inorder.length - j - 1);
					System.arraycopy(preorder, j + 1, newrightpreorder, 0, inorder.length - j - 1);
					TreeNode treeNode = new TreeNode();
					treeNode.val = preorder[i];
					treeNode.left = buildTree(newleftpreorder, newleftinorder);
					treeNode.right = buildTree(newrightpreorder, newrightinorder);
					return treeNode;

				}
			}
		}
		return null;

	}
}

//�����ֵ䷨��ʱ�临�Ӷ�Ϊn���ռ临�Ӷ�Ϊn��HashMap�ֵ䣬��Ϊ����ֵ��ֵΪ�����±ꣻ�ݹ麯��recur�����ڵ����������������߽磬��������ұ߽磻
//�ص�Ϊrecur�����������Լ�dic�����ã�ֻ���������ظ�ֵ�Ķ�����
//i - left + root + 1����Ϊ ���ڵ����� + ���������� + 1 = �������ĸ��ڵ�����
//���������������ĸ��ڵ���㲻��ֱ���� left+1 ���� i+1 �������ԭ��û�п��ǵ���ǰ�ڵ�û���������������������
//������� left �� i ���� right ���������� inorder �����������߽�ģ���Ҫֱ�������� preorder ȷ�����ڵ㣡����
class Solution_divide {
	int[] preorder;
	HashMap<Integer, Integer> dicHashMap = new HashMap<Integer, Integer>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;

		for (int i = 0; i < inorder.length; i++) {
			dicHashMap.put(inorder[i], i);
		}
		return recur(0, 0, preorder.length - 1);
	}

	TreeNode recur(int root, int left, int right) {
		if (left > right) {
			return null;
		}
		TreeNode treenode = new TreeNode();
		treenode.val = preorder[root];
		int i = dicHashMap.get(preorder[root]);
		treenode.left = recur(root + 1, left, i - 1);
		treenode.right = recur(root + i - left + 1, i + 1, right);
		return treenode;
	}

}