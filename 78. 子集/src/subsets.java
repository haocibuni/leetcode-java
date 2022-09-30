import java.util.ArrayList;
import java.util.List;

//回溯不剪枝法
class Solution {
//	二维整型数组
	List<List<Integer>> result = new ArrayList<>();
//	一位整型数组
	List<Integer> temp = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		backTracking(nums, 0);
		return result;
	}

	public void backTracking(int[] nums, int startIndex) {
//		添加路径，第一个为空集
		result.add(new ArrayList<>(temp));
//		不需要返回
		if (temp.size() == nums.length) {
			return;
		}
		for (int i = startIndex; i < nums.length; i++) {
			temp.add(nums[i]);
//			递归
			backTracking(nums, startIndex + 1);
//			回溯
			temp.remove(temp.size() - 1);
		}
	}
}