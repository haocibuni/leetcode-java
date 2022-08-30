import javax.swing.tree.TreeNode;

class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length);
	}

	public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
		if (left >= right) {
			return null;
		}
		if (right - left == 1) {
			return new TreeNode(nums[left]);
		}
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, left, mid);
		root.right = sortedArrayToBST(nums, mid + 1, right);
		return root;
	}
}
