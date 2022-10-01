import java.util.ArrayList;
import java.util.List;

//回溯标记法，一个维度
class Solution {
//	二维整型结果数组
	List<List<Integer>> result = new ArrayList<>();
//	一维整型临时数组
	List<Integer> temp = new ArrayList<>();
//	标记数组
	boolean[] used;

	public List<List<Integer>> permuteUnique(int[] nums) {
//		若为空，就返回空数组
		if (nums.length == 0) {
			return result;
		}
		used = new boolean[nums.length];
		backTracking(nums);
		return result;

	}

	public void backTracking(int[] nums) {
//		临时数组大小等于nums数组长度
		if (temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
//		在当前父节点，该数是否出现过
		boolean[] used1 = new boolean[21];
		for (int i = 0; i < nums.length; i++) {
//			若在纵向维度或横向维度使用过则跳过
			if (used[i] || used1[nums[i] + 10]) {
				continue;
			} else {
				used1[nums[i] + 10] = true;
				used[i] = true;
				temp.add(nums[i]);
				backTracking(nums);
				used[i] = false;
				temp.remove(temp.size() - 1);
			}
		}
	}
}