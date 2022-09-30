import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//���ݼ�֦��
class Solution {
//	�������
	List<List<Integer>> resultList = new ArrayList<>();
//	·������
	LinkedList<Integer> pathList = new LinkedList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		backTracking(k, n, 0, 1);
		return resultList;
	}

	private void backTracking(int k, int n, int sum, int startindex) {
//		���ܺʹ���n�����֦
		if (sum > n) {
			return;
		}
//		���ﵽ�̶�����
		if (k == pathList.size()) {
//			���ܺ͵���n����·����ӵ��������
			if (sum == n) {
				resultList.add(new ArrayList<>(pathList));
			}
			return;
		}
//		�ӿ�ʼ�ڵ㿪ʼ����������������̶������Ľڵ�
		for (int i = startindex; i <= 9 - (k - pathList.size()) + 1; i++) {
//			�ݹ�
			sum += i;
			pathList.add(i);
			backTracking(k, n, sum, i + 1);
//			����
			sum -= i;
			pathList.removeLast();
		}

	}
}