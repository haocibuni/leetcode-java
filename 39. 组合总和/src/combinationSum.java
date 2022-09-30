import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//���ݷ�
class Solution {
//	�����ά��������
	List<List<Integer>> result = new ArrayList<>();
//	��ʱһά��������
	List<Integer> temp = new LinkedList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		backTracking(candidates, target, 0, 0);
		return result;
	}

	public void backTracking(int[] candidates, int target, int sum, int startIndex) {
//		��Ҫ�½����������ӣ��������
		if (sum == target) {
			result.add(new ArrayList<>(temp));
			return;
		}
//		���ֿ��ظ���������temp֮������ظ���������ҪstartIndex
		for (int i = startIndex; i < candidates.length; i++) {
//			���ܺʹ���target��֮������ѭ������������������
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