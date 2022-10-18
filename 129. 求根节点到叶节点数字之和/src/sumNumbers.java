
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
	int count = 0;

	public int sumNumbers(TreeNode root) {
		sumNumbersrecur(root, 0);
		return count;
	}

	public void sumNumbersrecur(TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			count = count + sum * 10 + root.val;
			return;
		}
		sum = sum * 10 + root.val;
		sumNumbersrecur(root.left, sum);
		sumNumbersrecur(root.right, sum);
	}

}