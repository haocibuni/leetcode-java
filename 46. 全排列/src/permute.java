import java.util.ArrayList;
import java.util.List;

//���ݱ�Ƿ���һ��ά��
class Solution {
//	��ά���ͽ������
	List<List<Integer>> result = new ArrayList<>();
//	һά������ʱ����
	List<Integer> temp = new ArrayList<>();
//	�������
	boolean[] used;

	public List<List<Integer>> permute(int[] nums) {
//		��Ϊ�գ��ͷ��ؿ�����
		if (nums.length == 0) {
			return result;
		}
		used = new boolean[nums.length];
		backTracking(nums);
		return result;

	}

	public void backTracking(int[] nums) {
//		��ʱ�����С����nums���鳤��
		if (temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
//			��ʹ�ù�������
			if (used[i]) {
				continue;
			} else {
				used[i] = true;
				temp.add(nums[i]);
				backTracking(nums);
				used[i] = false;
				temp.remove(temp.size() - 1);
			}
		}
	}
}