import java.util.HashMap;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//分治暴力法，将前序数组分为左子树前序数组和右子树前序数组，将中序数组分为左子树中序数组和右子树中序数组；进行递归，返回条件为前序数组和中序数组中无相同元素
//空间复杂度高 时间复杂度为n2
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

//分治字典法，时间复杂度为n，空间复杂度为n；HashMap字典，键为数组值，值为数组下标；递归函数recur，根节点索引，中序遍历左边界，中序遍历右边界；
//重点为recur函数的索引以及dic的运用，只适用于无重复值的二叉树
//i - left + root + 1含义为 根节点索引 + 左子树长度 + 1 = 右子树的根节点索引
//左子树、右子树的根节点计算不能直接用 left+1 或者 i+1 来计算的原因：没有考虑到当前节点没有左子树或右子树的情况
//这里面的 left 和 i 还有 right 都是用来给 inorder 中序遍历处理边界的，不要直接用来给 preorder 确定根节点！！！
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