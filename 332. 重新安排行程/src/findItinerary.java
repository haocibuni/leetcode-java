import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
//	һά�������
	private LinkedList<String> res;
//	һά·������
	private LinkedList<String> path = new LinkedList<>();

	public List<String> findItinerary(List<List<String>> tickets) {
//		��Ŀ�ĵضԻ�Ʊ��������
		Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
//		���·�����׽ڵ�
		path.add("JFK");
//		ÿ�Ż�Ʊ�Ƿ�ʹ�ù�
		boolean[] used = new boolean[tickets.size()];
//		������ת��Ϊ������еݹ�
		backTracking((ArrayList) tickets, used);
		return res;
	}

	public boolean backTracking(ArrayList<List<String>> tickets, boolean[] used) {
//		��·�����ȵ��ڻ�Ʊ������1��������������
		if (path.size() == tickets.size() + 1) {
			res = new LinkedList(path);
			return true;
		}
//		����û�ù��Ļ�Ʊ�һ�Ʊ����ʼ�ص���·�������λ��
		for (int i = 0; i < tickets.size(); i++) {
			if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
//				����Ʊ��Ŀ�ĵ���ӵ�·�����ұ��Ϊʹ��
				path.add(tickets.get(i).get(1));
				used[i] = true;
//				�����ݹ�
				if (backTracking(tickets, used)) {
					return true;
				}
//				����
				used[i] = false;
				path.removeLast();
			}
		}
		return false;
	}
}