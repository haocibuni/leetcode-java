import java.util.ArrayList;
import java.util.List;

//�����ظ�Ԫ�ر�Ƿ�
class Solution {
//	��ά���ͽ������
	List<List<Integer>> result = new ArrayList<>();
//	һά������ʱ����
	List<Integer> temp = new ArrayList<>();

	public List<List<Integer>> findSubsequences(int[] nums) {
		backTracking(nums, 0);
		return result;
	}

	public void backTracking(int[] nums, int startIndex) {
//		����ʱ����ĳ��ȴ��ڵ��ڶ�����ӵ��������
		if (temp.size() >= 2) {
			result.add(new ArrayList<>(temp));
		}
//		������飬Ĭ��ȫΪ0
		int[] used = new int[201];
		for (int i = startIndex; i < nums.length; i++) {
//			1����ǰ��������ʱ���������һ����������ʱ����Ϊ��
//			2�������������ڴ˸��ڵ�δ��ʹ�ù�
			if (((!temp.isEmpty() && nums[i] >= temp.get(temp.size() - 1)) || temp.isEmpty())
					&& used[nums[i] + 100] != 1) {
//				���Ϊ��ʹ��
				used[nums[i] + 100] = 1;
//				���
				temp.add(nums[i]);
//				�ݹ���һ����
				backTracking(nums, i + 1);
//				����
				temp.remove(temp.size() - 1);
			} else {
				continue;
			}

		}
	}
}