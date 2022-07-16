import java.util.Stack;

//递归分治法 时间复杂度n2 空间复杂度n
//二叉搜索树的定义为 左子树所有节点<根节点 右子树所有节点>根节点 左右子树为二叉搜索树 且最后一位为根节点
class Solution_recur {
	public boolean verifyPostorder(int[] postorder) {
		return recur(postorder, 0, postorder.length - 1);
	}

	public boolean recur(int[] postorder, int i, int j) {
//		若i>=j 则子树为空或只有一个节点 不需要判断正确性
		if (i >= j) {
			return true;
		}
		int p = i;
		while (postorder[p] < postorder[j]) {
			p++;
		}
		int m = p;
		while (postorder[p] > postorder[j]) {
			p++;
		}
//		p==j为判断后序遍历是否正确的条件
//		若不能遍历到最后的节点说明左子树有大于根节点的情况或者右子树有小于根节点的情况
		return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
	}
}

//辅助栈法 时间复杂度n 空间复杂度n
//获取后序遍历的倒序 
//比较两个临近的节点 若为升序则为右节点
//若为降序则其父节点为大于该节点且最接近该节点的节点，并且该节点右面的节点都小于该节点的父节点
//辅助栈为递增的节点
class Solution_stack {
	public boolean verifyPostorder(int[] postorder) {
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MAX_VALUE;
		for (int i = postorder.length - 1; i >= 0; i--) {
			if (postorder[i] > root)
				return false;
//			递减的从栈中获取父节点 栈从低往上递增 所以不断出栈获取离该节点最近且大于该节点的值
			while (!stack.isEmpty() && stack.peek() > postorder[i])
				root = stack.pop();
//			将每个节点都入栈，每个右节点都可能为其它节点的父节点
			stack.add(postorder[i]);
		}
		return true;
	}
}