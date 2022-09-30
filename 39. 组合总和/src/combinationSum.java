import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//回溯法
class Solution {
//	结果二维整型数组
	List<List<Integer>> result = new ArrayList<>();
//	临时一维整型数组
	List<Integer> temp = new LinkedList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		backTracking(candidates, target, 0, 0);
		return result;
	}

	public void backTracking(int[] candidates, int target, int sum, int startIndex) {
//		需要新建数组进行添加，深拷贝问题
		if (sum == target) {
			result.add(new ArrayList<>(temp));
			return;
		}
//		数字可重复，不代表temp之间存在重复，所以需要startIndex
		for (int i = startIndex; i < candidates.length; i++) {
//			若总和大于target则之间跳出循环，避免遍历后面的数
			if (sum + candidates[i] > target) {
				break;
			}
			sum += candidates[i];
			temp.add(candidates[i]);
			backTracking(candidates, target, sum, i);
			sum -= candidates[i];
			temp.remove(temp.size() - 1);
		}
	}
}