import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
//	�������
	List<List<Integer>> result = new ArrayList<>();
//	·������
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> combine(int n, int k) {
		combineHelper(n, k, 1);
		return result;
	}

	/**
	 * ÿ�δӼ�����ѡȡԪ�أ���ѡ��ķ�Χ����ѡ��Ľ��ж�������������ѡ��ķ�Χ������Ҫ��startIndex
	 * 
	 * @param startIndex ������¼����ݹ���У����ϴ����￪ʼ���������Ͼ���[1,...,n] ����
	 */
//	1-n��Χ k��������� ��ʼ�±�
	private void combineHelper(int n, int k, int startIndex) {
		// ��ֹ����
		if (path.size() == k) {
			result.add(new ArrayList<>(path));
			return;
		}
//		�ӿ�ʼ�±꿪ʼ������������
//		��n=4 k=4��ô��һ��forѭ����Ԫ��2��ʼ�ı�����û������
//		���forѭ��ѡ�����ʼλ��֮���Ԫ�ظ��� �Ѿ����� ������Ҫ��Ԫ�ظ����ˣ���ô��û�б�Ҫ�����ˡ�
		for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
//			�ݹ�
			path.add(i);
			combineHelper(n, k, i + 1);
//			����
			path.removeLast();
		}
	}
}