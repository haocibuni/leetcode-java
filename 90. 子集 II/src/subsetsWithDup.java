import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//���ݲ���֦��
class Solution {
//	��ά��������
	List<List<Integer>> result = new ArrayList<>();
//	һλ��������
	List<Integer> temp = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		backTracking(nums, 0);
		return result;
	}

	public void backTracking(int[] nums, int startIndex) {
//		���·������һ��Ϊ�ռ�
		result.add(new ArrayList<>(temp));
//		����Ҫ����
		if (temp.size() == nums.length) {
			return;
		}
		for (int i = startIndex; i < nums.length; i++) {
			if (i > startIndex && nums[i - 1] == nums[i]) {
				continue;
			}
			temp.add(nums[i]);
//			�ݹ飬����startIndex����i����Ϊ������֮��������ظ�Ԫ��
			backTracking(nums, i + 1);
//			����
			temp.remove(temp.size() - 1);
		}
	}
}