import java.util.ArrayList;
import java.util.List;

//回溯重复元素标记法
class Solution {
//	二维整型结果数组
	List<List<Integer>> result = new ArrayList<>();
//	一维整型临时数组
	List<Integer> temp = new ArrayList<>();

	public List<List<Integer>> findSubsequences(int[] nums) {
		backTracking(nums, 0);
		return result;
	}

	public void backTracking(int[] nums, int startIndex) {
//		若临时数组的长度大于等于二则添加到结果数组
		if (temp.size() >= 2) {
			result.add(new ArrayList<>(temp));
		}
//		标记数组，默认全为0
		int[] used = new int[201];
		for (int i = startIndex; i < nums.length; i++) {
//			1、当前数大于临时数组中最后一个数，或临时数组为空
//			2、标记数组该数在此父节点未被使用过
			if (((!temp.isEmpty() && nums[i] >= temp.get(temp.size() - 1)) || temp.isEmpty())
					&& used[nums[i] + 100] != 1) {
//				标记为已使用
				used[nums[i] + 100] = 1;
//				添加
				temp.add(nums[i]);
//				递归下一个数
				backTracking(nums, i + 1);
//				回溯
				temp.remove(temp.size() - 1);
			} else {
				continue;
			}

		}
	}
}