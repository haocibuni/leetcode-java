import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
//	结果数组
	List<List<Integer>> result = new ArrayList<>();
//	路径数组
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> combine(int n, int k) {
		combineHelper(n, k, 1);
		return result;
	}

	/**
	 * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
	 * 
	 * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
	 */
//	1-n范围 k个数的组合 开始下标
	private void combineHelper(int n, int k, int startIndex) {
		// 终止条件
		if (path.size() == k) {
			result.add(new ArrayList<>(path));
			return;
		}
//		从开始下标开始遍历，遍历到
//		若n=4 k=4那么第一层for循环从元素2开始的遍历都没有意义
//		如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
		for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
//			递归
			path.add(i);
			combineHelper(n, k, i + 1);
//			回溯
			path.removeLast();
		}
	}
}