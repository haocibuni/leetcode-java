import javax.swing.tree.TreeNode;

class Solution {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree1(nums, 0, nums.length);
	}

	public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
		if (rightIndex - leftIndex < 1) {// û��Ԫ����
			return null;
		}
		if (rightIndex - leftIndex == 1) {// ֻ��һ��Ԫ��
			return new TreeNode(nums[leftIndex]);
		}
		int maxIndex = leftIndex;// ���ֵ����λ��
		int maxVal = nums[maxIndex];// ���ֵ
		for (int i = leftIndex + 1; i < rightIndex; i++) {
			if (nums[i] > maxVal) {
				maxVal = nums[i];
				maxIndex = i;
			}
		}
		TreeNode root = new TreeNode(maxVal);
		// ����maxIndex������������
		root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
		root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
		return root;
	}
}