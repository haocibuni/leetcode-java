import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//回溯剪枝法
class Solution {
//	结果数组
	List<List<Integer>> resultList = new ArrayList<>();
//	路径链表
	LinkedList<Integer> pathList = new LinkedList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		backTracking(k, n, 0, 1);
		return resultList;
	}

	private void backTracking(int k, int n, int sum, int startindex) {
//		若总和大于n，则剪枝
		if (sum > n) {
			return;
		}
//		若达到固定数量
		if (k == pathList.size()) {
//			若总和等于n，则将路径添加到结果数组
			if (sum == n) {
				resultList.add(new ArrayList<>(pathList));
			}
			return;
		}
//		从开始节点开始遍历，到不能满足固定数量的节点
		for (int i = startindex; i <= 9 - (k - pathList.size()) + 1; i++) {
//			递归
			sum += i;
			pathList.add(i);
			backTracking(k, n, sum, i + 1);
//			回溯
			sum -= i;
			pathList.removeLast();
		}

	}
}